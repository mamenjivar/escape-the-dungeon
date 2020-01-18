/**
 * Escape the Dungeon
 * 
 * Author: Miguel Menjivar
 * 
 * Synopsis:
 * The user has to take 10 steps in order to exit the dungeon.
 * For every step the user takes, enemies might spawn and attack
 * the user. The user has the opportunity to use weapons to fend off
 * the attacks. There will be power-ups given to help aid the user in
 * completing the game. 
 * 
 * Main.java
 * Entry point for program
 */

class Main {
    public static void main(final String[] args){
        GameEngine ge = new GameEngine();

        ge.start();
    }
}