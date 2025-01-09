package CPT;

public class MeleeWeapon {
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
        
    
        public MeleeWeapon(String name, String attackName, double impact, double puncture, double slash, double baseDamage, double totalDamage, double critChance, double critMultiplier, double statusChance, double speed, int mastery, String introducedDate, String weaponClass) {
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
    public String getName(){
        return name;
    }
    public String getAttackName(){ 
        return attackName;
    }
    public double getImpact(){
        return impact;
    }
    public double getPuncture(){
        return puncture; 
    }
    public double getSlash(){ 
        return slash;
    }
    public double getBaseDamage(){
        return baseDamage;
    }
    public double getTotalDamage(){
        return totalDamage;
    }
    public double getCritChance(){
        return critChance;
    }
    public double getCritMultiplier(){
        return critMultiplier;
    }
    public double getStatusChance(){
        return statusChance;
    }
    public double getSpeed(){
        return speed;
    }
    public int getMastery(){
        return mastery;
    }
    public String getIntroducedDate(){
        return introducedDate;
    }
    public String getWeaponClass(){
        return weaponClass;
    }
    public String toString() {
        return name + " " + attackName + " " + impact + " " + puncture + " " + slash + " " + baseDamage + " " + totalDamage + " " + critChance + " " + critMultiplier + " " + statusChance + " " + speed + " " + mastery + " " + introducedDate + " " + weaponClass;
    }
}
