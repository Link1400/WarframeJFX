package CPT;

public class MeleeWeapon {

    // Initializing variables
    private String name;
    private String attackName;
    private double impact;
    private double puncture;
    private double slash;
    private double baseDamage;
    private double totalDamage;
    private double critChance;
    private double critMultiplier;
    private double statusChance;
    private double speed;
    private int mastery;
    private String introducedDate;
    private String weaponClass;

    /**
     * Constructor which will set the variables to the given stats when creating the weapon object
     * @param name contains the name of the weapon
     * @param attackName contains the name of the attack name of the weapon
     * @param impact contains the impact damage of the weapon
     * @param puncture contains the puncture damage of the weapon
     * @param slash contains the slash damage of the weapon
     * @param baseDamage contains the base damage of the weapon
     * @param totalDamage contains the total damage of the weapon
     * @param critChance contains the critical chance of the weapon
     * @param critMultiplier contains the critical multiplier of the weapon
     * @param statusChance contains the status chance of the weapon
     * @param speed contains the attack speed of the weapon
     * @param mastery contains the mastery rank of the weapon
     * @param introducedDate contains the date that the weapon was introduced in
     * @param weaponClass contains the class of the weapon
     */
    public MeleeWeapon(String name, String attackName, double impact, double puncture, double slash, double baseDamage,
            double totalDamage, double critChance, double critMultiplier, double statusChance, double speed,
            int mastery, String introducedDate, String weaponClass) {
        this.name = name;
        this.attackName = attackName;
        this.impact = impact;
        this.puncture = puncture;
        this.slash = slash;
        this.baseDamage = baseDamage;
        this.totalDamage = totalDamage;
        this.critChance = critChance;
        this.critMultiplier = critMultiplier;
        this.statusChance = statusChance;
        this.speed = speed;
        this.mastery = mastery;
        this.introducedDate = introducedDate;
        this.weaponClass = weaponClass;
    }

    /**
     * Getter method for the weapons name
     * @return the weapons name
     */
    public String getName() {
        return name;
    }

    /**
     * Getter method for the weapons attack name
     * @return the weapons attack name
     */
    public String getAttackName() {
        return attackName;
    }

    /**
     * Getter method for the weapons impact damage
     * @return the weapons impact damage
     */
    public double getImpact() {
        return impact;
    }

    /**
     * Getter method for the weapons puncture damage
     * @return the weapons puncture damage
     */
    public double getPuncture() {
        return puncture;
    }

    /**
     * Getter method for the weapons slash damage
     * @return the weapons slash damage
     */
    public double getSlash() {
        return slash;
    }

    /**
     * Getter method for the weapons base damage
     * @return the weapons base damage
     */
    public double getBaseDamage() {
        return baseDamage;
    }

    /**
     * Getter method for the weapons total damage
     * @return the weapons total damage
     */
    public double getTotalDamage() {
        return totalDamage;
    }

    /**
     * Getter method for the weapons critical chance
     * @return the weapons critical chance
     */
    public double getCritChance() {
        return critChance;
    }

    /**
     * Getter method for the weapons critical multiplier
     * @return the weapons critical multiplier
     */
    public double getCritMultiplier() {
        return critMultiplier;
    }

    /**
     * Getter method for the weapons status chance
     * @return the weapons status chance
     */
    public double getStatusChance() {
        return statusChance;
    }

    /**
     * Getter method for the weapons attack speed 
     * @return the weapons attack speed
     */
    public double getSpeed() {
        return speed;
    }

    /**
     * Getter method for the weapons mastery rank
     * @return the weapons required mastery rank
     */
    public int getMastery() {
        return mastery;
    }

    /**
     * Getter method for the weapons creation date
     * @return the weapons creation date
     */
    public String getIntroducedDate() {
        return introducedDate;
    }

    /**
     * Getter method for the weapons class
     * @return the weapons class
     */
    public String getWeaponClass() {
        return weaponClass;
    }

    /**
     * toString method to get all the stats when printed
     */
    public String toString() {
        return "MeleeWeapon{" +
                "name='" + name + '\'' +
                ", attackName='" + attackName + '\'' +
                ", impact=" + impact +
                ", puncture=" + puncture +
                ", slash=" + slash +
                ", baseDamage=" + baseDamage +
                ", totalDamage=" + totalDamage +
                ", critChance=" + critChance +
                ", critMultiplier=" + critMultiplier +
                ", statusChance=" + statusChance +
                ", speed=" + speed +
                ", mastery=" + mastery +
                ", introducedDate='" + introducedDate + '\'' +
                ", weaponClass='" + weaponClass + '\'' +
                '}';
    }
}
