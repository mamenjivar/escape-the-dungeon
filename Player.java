/**
 * Escape the Dungeon
 * 
 * Author: Miguel
 * 
 * Player.java
 * Has all player attributes
 */
class Player {
    // amount of health player currently has 
    private int health;

    // max amount of health player can get
    final private int MAX_HEALTH = 20;
    final private int DEAD_HEALTH = 0;

    // constructor
    public Player(){
        health = MAX_HEALTH;
    }

    /**
     * When the player gets hit
     * player loses health points
     * 
     * @param hitPoint
     */
    public void playerHit(int hitPoint){
        health -=  hitPoint;
    }

    /**
     * checks if player is dead or alive
     * 
     * @return statusHealth
     * true = dead
     * false = alive
     */
    public boolean deadAlive(){
        boolean statusHealth;

        if(health == DEAD_HEALTH){
            statusHealth = true;
        } else {
            statusHealth = false;
        }

        return statusHealth;
    }

    /**
     * setter for health
     * 
     * @param health
     */
    public void sethealth(int health){
        this.health = health;
    }

    /**
     * Getter for health
     * 
     * @return
     */
    public int getHealth(){
        return health;
    }
}