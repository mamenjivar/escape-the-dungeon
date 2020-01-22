/**
 * Escape the Dungeon
 * 
 * Author: Miguel Menjivar
 * 
 * GameEngine.java
 * Will handle all the logic of the game
 */
import java.util.Scanner;
import java.util.Random;

class GameEngine{
    UserInterface ui;
    Player player;
    Enemy enemy;

    Scanner keyboard;
    Random rand;

    // 10 steps to exit dungeon
    final int MAX_STEPS = 10;

    int steps; // amount of steps user takes
    int weaponNum; // type of weapon by player
    int enemyGun; // random weapon for enemy to use after each spawn


    // Constructor
    public GameEngine(){
        ui = new UserInterface();
        player = new Player(); // might need to remove from here in order to create multiple players for multiple games

        keyboard = new Scanner(System.in);
        rand = new Random();

        steps = 0;
        weaponNum = 0;
    }

    // starts the game
    public void start(){
        // title of the game
        ui.titleGame();

        // loop this
        choices();

        // closes scanner
        keyboard.close();
    }

    /**
     * Option for user to choose
     * main menu
     */
    public void choices(){
        // saves number for choice
        int num = 0;
        boolean menuMainLoop = true;

        while(menuMainLoop){

            ui.mainMenu();
            try {
                // prints out main menu
                // keyboard input user
                num = keyboard.nextInt();
                
                menuMainLoop = false;
            } catch (Exception e) {
                keyboard.next();
                e.printStackTrace();
                ui.menuMainError();
            }

        }

        switch(num){
            case 1: // game start
                gameStart();
                break;
            case 2: // about game
                ui.aboutGame();
                break;
            case 3: // about author
                ui.author();
                break;
            case 4: // game elements
                ui.gameElements();
                break;
            case 5: // exit game
                exit();
                break;
            default: // option doesn't exist
                ui.mainMenuChoiceDNE();
        }
    }

    /**
     * Start of the game
     * to escape dungeon
     */
    public void gameStart(){
        // title for start game
        ui.gameStartTitle(); 

        weaponSelect(); // selects weapon for player to use

        // loops until 10 steps taken to exit cave
        for(int i = 0; i < MAX_STEPS; i++){
            ui.stepsTaken(steps + 1); // steps taken so far
            situation();
            incrementSteps(); // step taken after every encounter/situation
        }

        // ending scene
        ui.exitDungeon();
    }

    /**
     * prompts user to choose what weapon
     * to use for the course of the game
     */
    public void weaponSelect(){
        boolean weaponSelectLoop = true;

        while(weaponSelectLoop){
            try {
                // makes player choose the
                // type of weapon to use
                ui.weaponSelect();
                weaponNum = keyboard.nextInt();
                keyboard.nextLine();

                weaponSelectLoop = false;
            } catch (Exception e) {
                e.printStackTrace();
                keyboard.next();
                ui.weaponSelectError();
            }
        }
        player.chooseWeapon(weaponNum);
        ui.selectedWeapon(weaponNum);
    }

    /**
     * when situation arises
     * either enemy spawns, or nothing happens
     */
    public void situation(){ 
        boolean loop = true;
        String encounter = null;

        // when an enemy spawns
        enemySpawn();

        // loops for user to choose if wants to pull trigger or not
        while(loop){
            ui.playerHealth(player.getHealth()); // player health
            ui.encounter(); // shoot or run
            encounter = keyboard.nextLine();

            // simulates player pulling trigger
            // or running away 
            if(encounter.equals("s")){

                // when both player and enemy shoot randomizer
                duel();

                // checks if enemy is dead or alive
                if (enemy.deadAlive()) { // enemy DEAD
                    ui.enemyDied();
                    loop = false;

                    powerUp();
                } else if(player.deadAlive()){ // player dead
                    ui.playerDied();
                    exit();
                } else { // ALIVE
                    ui.enemyHealth(enemy.getHealth()); // prints enemy health
                }
            } else { // when you run away from encounter
                ui.runAway();
                loop = false;

                powerUp();
            }
        }
    }

    /**
     * When enemy spawns
     * randomize it with weapon
     */
    public void enemySpawn(){
        enemy = new Enemy();
        enemyGun = rand.nextInt(3) + 1;
        enemy.chooseWeapon(enemyGun);

        // prints enemy information
        ui.enemySpawn();
        ui.enemyHealth(enemy.getHealth());
        ui.enemyWeapon(enemyGun);
    }

    /**
     * when both enemy and player shoot eachother
     * randomize if hit or miss
     */
    public void duel(){
        int randShoot;

        // player shooting randmization
        randShoot = rand.nextInt(10) + 1;
        if(randShoot < 5){ // miss
            randShootPlayer(0);
        } else { // hit
            randShootPlayer(1);

            enemy.enemyHit(player.playerGunDamage());
        }

        // enemy shooting randomization
        randShoot = rand.nextInt(10) + 1;
        if(randShoot < 5){ // miss
            ui.hitMiss(2);
            
        } else { // hit
            enemy.enemyShoot();
            ui.hitMiss(3);

            player.playerHit(enemy.enemyGunDamage());
        }
    }

    /**
     * simulates shooting weapon
     * and randomizes hit or miss
     * for player
     * 
     * @param hitMiss
     */
    public void randShootPlayer(int hitMiss){
        player.playerShoot();
        ui.hitMiss(hitMiss);
        ui.gunCounter(weaponNum, player.weaponCapacity());      
    }

    /**
     * logic when a powerup
     * drops after encounter
     * 
     * ammo = 1; health = 2; nothing = 3
     */
    public void powerUp(){
        int powerUpSpawn = rand.nextInt(3) + 1;

        switch(powerUpSpawn){
            case 1: // AMMO
                player.ammoPowerUp();
                ui.powerUp(powerUpSpawn);
                ui.ammoUp(player.weaponCapacity());
                break;
            case 2: // HEALTH
                player.healthPowerup();
                ui.powerUp(powerUpSpawn);
                ui.healthUp(player.getHealth());
                break;
            case 3: // NOTHING
                ui.powerUp(powerUpSpawn);
                break;
            default:
        }
    }

    /**
     * simulates player pulling the trigger
     */
    public void playerShoot(){
        if(player.isWeaponEmpty()){ // true = empty
            ui.weaponEmpty();
        } else {
            player.playerShoot(); // subtracts bullet from capacity

            enemy.enemyHit(player.playerGunDamage()); // simulates enemy getting hit.
        }
    }

    /**
     * increment steps by 1
     * to exit dungeon
     */
    public void incrementSteps(){
        steps++;
    }

    /**
     * Check if the user has made it out of the cave
     * 
     * @return dungeonFree
     * true = made it to 10 steps and escaped dungeon
     * false = less than 10 steps and needs more to go
     */
    public boolean exitDungeon(){
        boolean dungeonFree;
        if(steps == MAX_STEPS - 1) {
            dungeonFree = true;
        } else {
            dungeonFree = false;
        }

        return dungeonFree;
    }

    /**
     * Setter for steps
     * 
     * @param step
     */
    public void setSteps(int step){
        steps = step;
    }

    /**
     * getter for steps
     * 
     * @return number of steps taken
     */
    public int getSteps(){
        return steps;
    }

    /**
     * Exits out the program
     */
    public void exit(){
        ui.exit();
        System.exit(0);
    }
}