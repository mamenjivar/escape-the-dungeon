/**
 * Escape the Dungeon
 * 
 * Author: Miguel
 * 
 * Enemy.java
 * Has all enemy attributes
 */
class Enemy{
    private int health;

    final private int MAX_HEALTH = 5;
    final private int DEAD_HEALTH = 0;

    /**
     * constructor
     */
    public Enemy(){
        health = MAX_HEALTH;
    }

    /**
     * when the enemy gets hit
     * 
     * @param hitPoint
     */
    public void enemyHit(int hitPoint){
        health -= hitPoint;
    }

    /**
     * checks if enemy is dead or alive
     * 
     * @return statusHealth
     * true = dead;
     * false = alive
     */
    public boolean deadAlive() {
        boolean statusHealth;

        if (health == DEAD_HEALTH) {
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
    public void sethealth(int health) {
        this.health = health;
    }

    /**
     * Getter for health
     * 
     * @return
     */
    public int getHealth() {
        return health;
    }
}