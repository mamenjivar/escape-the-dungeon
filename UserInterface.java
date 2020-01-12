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
     * how many steps user has taken so far
     * 
     * @param steps
     */
    public void stepsTaken(int steps){
        System.out.println("You have taken " + steps + " step(s)");
    }

    /**
     * prints exit message
     */
    public void exit(){
        System.out.println("Goodbye...");
    }
 }