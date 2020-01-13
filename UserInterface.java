/**
 * Escape the Dungeon
 * 
 * Author: Miguel Menjivar
 * 
 * UserInterface.java
 * This file will hold all the user input and
 * text for this program
 */

 class UserInterface {

    /**
     * Main menu for application
     */
    public void mainMenu(){
        System.out.print("\nMain Menu\n"
                            + "1) Start Game\n"
                            + "2) About Game\n"
                            + "3) About Author\n"
                            + "4) Game Elements\n"
                            + "5) Exit\n");
        System.out.print(">> ");
    }

    /**
     * prints title of game
     */
    public void titleGame(){
        System.out.print("\nEscape the Dungeon\n");
    }

    /**
     * Will print what the game is about
     */
    public void aboutGame(){
        System.out.println("\nEscape the Dungeon: \n"
                            + "The user has to take 10 steps in order to exit the dungeon.\n"
                            + "For every step the user takes, enemies might spawn and attack the user.\n"
                            + "The user has the opportunity to use weapons to fend off the attacks.\n"
                            + "There will be power-ups given to help aid the user in completing the game.\n");
    }

    /**
     * When user has successfully exited the dungeon
     */
    public void exitDungeon(){
        System.out.println("Game Over - You have escaped the dungeon!!");
    }

    /**
     * When the game starts title
     */
    public void gameStartTitle() {
        System.out.println("\nEscape the Dungeon : Game Start\n");
    }

    /**
     * prints how much health player has
     * to keep track of it
     * 
     * @param health
     */
    public void playerHealth(int health){
        System.out.println("Player has " + health + " health remaining.");
    }

    /**
     * prints how much health enemy has
     * to keep track of it
     * 
     * @param health
     */
    public void enemyHealth(int health) {
        System.out.println("Enemy has " + health + " health remaining.\n");
    }

    /**
     * Prints when the enemy has died and has lost
     * all health
     */
    public void enemyDied(){
        System.out.println("The Enemy has died!");
    }

    /**
     * prompts user to shoot or run away
     * when they encounter an enemy
     */
    public void encounter(){
        System.out.print("Would you like to: \n"
                            + "   (s) shoot\n"
                            + "   (r) run\n"
                            + "   >> ");
    }

    /**
     * prints what weapon the user is using 
     */
    public void selectedWeapon(int weaponNumber){
        switch(weaponNumber){
            case 1: 
                System.out.println("You have selected the Handgun");
                break;
            case 2:
                System.out.println("You have selected the Shotgun");
                break;
            case 3:
                System.out.println("You have selected the Rifle");
                break;
            default:
                System.out.println("Weapon does not exist (UI)");
        }
    }

    /**
     * how many steps user has taken so far
     * 
     * @param steps
     */
    public void stepsTaken(int steps){
        System.out.println("You have taken " + steps + " step(s)");
    }

    /**
     * Have player select weapon to use
     */
    public void weaponSelect() {
        System.out.println("Please choose a weapon:\n"
                            + "1) Handgun\n"
                            + "      Accuracy: 80%\n"
                            + "      Clip: 7 rounds\n"
                            + "      Damage: 1\n"
                            + "2) Shotgun\n"
                            + "      Accuracy: 50%\n"
                            + "      Clip: 5 rounds\n"
                            + "      Damage: 3\n"
                            + "3) Rifle\n"
                            + "      Accuracy: 90%\n"
                            + "      Clip: 10 rounds\n"
                            + "      Damage: 2" );
        System.out.print(">> ");
    }

    /**
     * prints exit message
     */
    public void exit(){
        System.out.println("Goodbye...");
    }
 }