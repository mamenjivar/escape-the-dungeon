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
                System.out.println("You have selected the Handgun\n");
                break;
            case 2:
                System.out.println("You have selected the Shotgun\n");
                break;
            case 3:
                System.out.println("You have selected the Rifle\n");
                break;
            default:
                System.out.println("Weapon does not exist (UI)\n");
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
     * prompt
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
     * When user chooses an option other than the ones provided
     * Will show an error message that option doesn't exist
     */
    public void mainMenuChoiceDNE() {
        System.out.println("This option does not exist! (Main Menu && UI)");
    }

    /**
     * prints out gun counter and how much ammunition
     * is remaining in the weapon
     * 
     * @param gunType 
     * 1 = Handgun
     * 2 = Shotgun
     * 3 = Rifle 
     * @param gunCounter
     * How many bullets remain in weapon
     */
    public void gunCounter(int gunType, int gunCounter){
        switch(gunType){
            case 1:
                System.out.println("handgun: " + gunCounter + " round(s) remaining");
                break;
            case 2:
                System.out.println("Shotgun: " + gunCounter + " round(s) remaining");
                break;
            case 3:
                System.out.println("Rifle: " + gunCounter + " round(s) remaining");
                break;
            default:
                System.out.println("");
        }
    }

    /**
     * When the player finds a powerup
     * after an encounter.
     * 
     * ammo = 1; health = 2; nothing = 3
     */
    public void powerUp(int printPowerUp){
        switch (printPowerUp) {
            case 1:
                System.out.println("YOU FOUND AMMUNITION!");
                break;
            case 2:
                System.out.println("YOU FOUND A HEALTH PACK!");
                break;
            case 3:
                System.out.println("NOTHING WAS FOUND");
                break;
            default:
                System.out.println("NOT A POWERUP");
                break;
        }
    }

    /**
     * After health has been added to the player
     * 
     * @param health
     */
    public void healthUp(int health){
        System.out.println("You now have " + health + " points");
    }

    /**
     * After ammunition has been added to player's
     * weapon
     * 
     * @param ammo
     */
    public void ammoUp(int ammo){
        System.out.println("You have " + ammo + " rounds total");
    }

    /**
     * prints whether if 
     * weapon hits or misses its target
     * 
     * @param hitMiss
     * 1 = hit
     * 0 = miss
     */
    public void hitMiss(int hitMiss){
        if(hitMiss == 1){
            System.out.println("HIT!");
        } else{
            System.out.println("MISS!");
        }
    }

    /**
     * Prints if there is no ammunition
     * in the clip and player can't shoot
     * enemy
     */
    public void weaponEmpty(){
        System.out.println("THE CLIP IS EMPTY! CAN'T SHOOT!");
    }

    /**
     * when player decides to run away
     * from encounter
     */
    public void runAway(){
        System.out.println("RAN AWAY");
    }

    /**
     * Information about the author of the
     * game
     * 
     * TODO: input information about author below
     */
    public void author(){
        System.out.println("");
    }

    /**
     * Information about elements of the game
     * what weapons available, enemies, powerup information, etc
     * 
     * TODO: fill out information below about game elements
     */
    public void gameElements(){
        System.out.println("");
    }

    /**
     * prints exit message
     */
    public void exit(){
        System.out.println("Goodbye...");
    }
 }