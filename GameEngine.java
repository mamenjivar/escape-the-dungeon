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
    // 0-9 for programming purposes = 10
    final int MAX_STEPS = 10;

    // amount of steps user takes
    int steps;

    // Constructor
    public GameEngine(){
        ui = new UserInterface();
        player = new Player(); // might need to remove from here in order to create multiple players for multiple games

        keyboard = new Scanner(System.in);

        steps = 0;
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

        switch(num){
            case 1: // game start
                gameStart();
                break;
            case 2: // about game
                ui.aboutGame();
                break;
            case 3: // about author
                break;
            case 4: // game elements
                break;
            case 5: // exit game
                exit();
                break;
            default:

        }
    }

    /**
     * Start of the game
     * to escape dungeon
     */
    public void gameStart(){
        int weaponNum = 0;
        // title for start game
        ui.gameStartTitle(); 

        // makes player choose the
        // type of weapon to use
        ui.weaponSelect();
        weaponNum = keyboard.nextInt();
        player.chooseWeapon(weaponNum);

        // loops until 10 steps taken to exit cave
        for(int i = 0; i < MAX_STEPS; i++){
            ui.stepsTaken(steps + 1); // steps taken so far
            ui.playerHealth(player.getHealth());
            situation();
            incrementSteps(); // step taken after every encounter/situation
        }

        // ending scene
        ui.exitDungeon();
    }

    /**
     * when situation arises
     * either enemy spawns, or nothing happens
     */
    public void situation(){ 
        enemy = new Enemy(); // creates new enemy to fight
        ui.enemyHealth(enemy.getHealth()); // tracks enemy health health
    }

    /**
     * increment steps by 1
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