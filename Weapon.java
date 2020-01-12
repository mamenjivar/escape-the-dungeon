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
    // holds the type of gun/ ammunition for that particular weapon
    private int gunType;
    private int gunAmmunition;


    // pistol = 1
    // shotgun = 2
    // rifle = 3

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
        gunType = 0;
        gunAmmunition = 0;
    }

    /**
     * assigns weapon to player/enemy
     * 
     * @param choose
     */
    public void chooseWeapon(int choose){
        gunType = choose;
        switch(choose){
            case 1: 
                gunAmmunition = MAX_HANDGUN_AMMO;
                break;
            case 2:
                 gunAmmunition = MAX_SHOTGUN_AMMO;
                 break;
            case 3:
                gunAmmunition = MAX_RIFLE_AMMO;
                break;
            default:
                System.out.println("Weapon does not exist (weapon class)");
        }
    }

    /**
     * when player shoots weapon
     */
    public void shoot(){
        gunAmmunition--;
    }

    /**
     * setter for type of gun
     * @param gunType
     */
    public void setGunType(int gunType){
        this.gunType = gunType;
    }

    /**
     * getter for type of gun
     * 
     * @return
     */
    public int getGunType(){
        return gunType;
    }
}