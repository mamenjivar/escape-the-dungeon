/**
 * Escape the Dungeon
 * 
 * Author: Miguel
 * 
 * Weapon.java
 * Will generate weapons for both player and enemy
 * to inflict damage to each other
 */
class Weapon{
    private int ammo;

    // holds the max capacity of each weapon
    final private int MAX_HANDGUN_AMMO = 5;
    final private int MAX_SHOTGUN_AMMO = 6;
    final private int MAX_RIFLE_AMMO = 7;

    // holds total damage of each weapon
    final private int MAX_DAMAGE_HANDGUN = 1;
    final private int MAX_DAMAGE_SHOTGUN = 3;
    final private int MAX_DAMAGE_RIFLE = 2;

    /**
     * constructor
     */
    public Weapon(){
        ammo = 0;
    }

    


}