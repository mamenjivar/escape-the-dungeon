/**
 * Escape the Dungeon
 * 
 * Author: Miguel
 * 
 * Player.java
 * Has all player attributes
 */
class Player {
    Weapon weapon;

    // amount of health player currently has 
    private int health;

    // max amount of health player can get
    final private int MAX_HEALTH = 20;
    final private int DEAD_HEALTH = 0;

    /**
     * constructor
     */
    public Player(){
        health = MAX_HEALTH;
        weapon = new Weapon();
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
     * Simulates player pulling the trigger
     */
    public void playerShoot(){
        weapon.shoot();
    }

    /**
     * will return the damage caused by 
     * weapon of choice
     * 
     * @return weapon damage
     */
    public int playerGunDamage(){
        return weapon.damage();
    }

    /**
     * finalizes weapon choice for player
     * 
     * @param choice
     */
    public void chooseWeapon(int choice){
        weapon.chooseWeapon(choice);
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

        if(health <= DEAD_HEALTH){
            statusHealth = true;
        } else {
            statusHealth = false;
        }

        return statusHealth;
    }

    /**
     * has current ammunition capacity 
     * 
     * @return
     */
    public int weaponCapacity(){
        return weapon.getGunAmmunition();
    }

    /**
     * Checks if the capacity of the weapon
     * is empty
     * 
     * @return isEmpty
     * true = capacity empty
     * false = not empty
     */
    public boolean isWeaponEmpty(){
        boolean isEmpty;
        if(weapon.getGunAmmunition() <= 0) {
            isEmpty = true;
        } else {
            isEmpty = false;
        }

        return isEmpty;
    }

    /**
     * When the player picks up a health powerup
     * it adds to total health of player
     * 
     * will heal a total of 5 health points
     */
    public void healthPowerup(){
        health += 5;
    }

    /**
     * When player gets ammunition
     * for weapon powerUp
     */
    public void ammoPowerUp(){
        weapon.ammoUp();
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