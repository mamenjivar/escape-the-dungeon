/**
 * Escape the Dungeon
 * 
 * Author: Miguel Menjivar
 * 
 * GameEngine.java
 * Will handle all the logic of the game
 */
import java.util.Scanner;

class GameEngine{
    UserInterface ui;
    Player player;
    Enemy enemy;

    Scanner keyboard; 

    // 10 steps to exit dungeon
    final int MAX_STEPS = 10;

    int steps; // amount of steps user takes
    int weaponNum; // type of weapon by player


    // Constructor
    public GameEngine(){
        ui = new UserInterface();
        player = new Player(); // might need to remove from here in order to create multiple players for multiple games

        keyboard = new Scanner(System.in);

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

        // prints out main menu
        // keyboard input user
        ui.mainMenu();
        num = keyboard.nextInt();

        // TODO: add other cases for main menu
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
        // makes player choose the
        // type of weapon to use
        ui.weaponSelect();
        weaponNum = keyboard.nextInt();
        keyboard.nextLine();
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

        enemy = new Enemy(); // creates new enemy to fight
        ui.enemyHealth(enemy.getHealth()); // tracks enemy health

        // loops for user to choose if wants to pull trigger or not
        while(loop){
            ui.playerHealth(player.getHealth()); // player health
            ui.encounter(); // shoot or run
            encounter = keyboard.nextLine();

            // simulates user pulling trigger
            // or running away 
            if(encounter.equals("s")){
                playerShoot(); // simulates shooting motion for player
                ui.hitMiss(1); // TODO: change parameter to match hit or miss
                ui.gunCounter(weaponNum, player.weaponCapacity()); 

                // checks if enemy is dead or alive
                if (enemy.deadAlive()) {
                    ui.enemyDied();
                    loop = false;
                } else {
                    ui.enemyHealth(enemy.getHealth()); // prints enemy health
                }
            } else { // when you run away from encounter
                ui.runAway();
                loop = false;
            }
        }
    }

    /**
     * When enemy spawns
     * randomize it
     */
    public void enemySpawn(){

    }

    /**
     * logic when a powerup
     * drops after encounter
     * 
     * TODO: randomize the powerup
     * ammo, health
     */
    public void powerUp(){

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
        if(steps == MAX_STEPS) {
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