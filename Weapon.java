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
    private int gunDamage;


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
            case 1: // handgun choice
                gunAmmunition = MAX_HANDGUN_AMMO;
                gunDamage = MAX_DAMAGE_HANDGUN;
                break;
            case 2: // shotgun choice
                gunAmmunition = MAX_SHOTGUN_AMMO;
                gunDamage = MAX_DAMAGE_SHOTGUN;
                break;
            case 3: // rifle choice
                gunAmmunition = MAX_RIFLE_AMMO;
                gunDamage = MAX_DAMAGE_RIFLE;
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
     * when player gets a powerUp
     * adds 3 bullets to weapon
     */
    public void ammoUp(){
        gunAmmunition += 3;
    }

    /**
     * When the user inflicts damage to enemy
     * or when enemy inflicts damage to user
     * 
     * @param gunDamage
     * @return
     */
    public int damage(){
        return gunDamage;
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

    /**
     * Setter for ammunition of weapon
     * 
     * @param gunAmmunition
     */
    public void setGunAmmunition(int gunAmmunition){
        this.gunAmmunition = gunAmmunition;
    }

    /**
     * getter for ammunition of weapon
     * 
     * @return
     */
    public int getGunAmmunition(){
        return gunAmmunition;
    }
}