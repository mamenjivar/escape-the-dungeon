/**
 * Escape the Dungeon
 * 
 * Author: Miguel
 * 
 * Enemy.java
 * Has all enemy attributes
 */
class Enemy{
    Weapon weapon;

    // amount of health enemy will have
    private int health;

    final private int MAX_HEALTH = 5;
    final private int DEAD_HEALTH = 0;

    /**
     * constructor
     */
    public Enemy(){
        health = MAX_HEALTH;
        weapon = new Weapon();
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
     * simulates enemy pulling the trigger
     */
    public void enemyShoot(){
        weapon.shoot();
    }

    /**
     * finalizes weapon choice for enemy
     * 
     * @param choice
     */
    public void chooseWeapon(int choice){
        weapon.chooseWeapon(choice);
    }

    /**
     * returns damage caused by weapon
     * of choice
     * 
     * @return weapon damage
     */
    public int enemyGunDamage(){
        return weapon.damage();
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

        if (health <= DEAD_HEALTH) {
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