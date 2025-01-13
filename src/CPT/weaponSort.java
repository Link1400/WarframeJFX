package CPT;
import java.util.ArrayList;

public class weaponSort {
    
    private ArrayList<MeleeWeapon> originallist;

    public weaponSort(ArrayList<MeleeWeapon> originallist) {
        this.originallist = originallist;
    }
    
    public ArrayList<MeleeWeapon> insertionSort(ArrayList<MeleeWeapon> array, String field) {
        for (int i = 1; i < array.size(); i++) {
            MeleeWeapon weapon = array.get(i);
            Double property = getFieldValueSort(weapon, field);
            int selectedProperty = i - 1;
            
            while (selectedProperty >= 0 && getFieldValueSort(weapon, field) > property) {
                array.set(selectedProperty + 1, array.get(selectedProperty));
                selectedProperty--;
            }
            array.set(selectedProperty + 1, weapon);
        }
        return array; 
    }

    private Double getFieldValueSort(MeleeWeapon weapon, String field) {
        switch (field) {
            case "Impact":
                return weapon.getImpact();
            case "Puncture":
                return weapon.getPuncture();
            case "Slash":
                return weapon.getSlash();
            case "Base Damage":
                return weapon.getBaseDamage();
            case "Total Damage":
                return weapon.getTotalDamage();
            case "Critical Hit Chance":
                return weapon.getCritChance();
            case "Critical Hit Multiplier":
                return weapon.getCritMultiplier();
            case "Status Effect Chance":
                return weapon.getStatusChance();
            case "Attack Speed":
                return weapon.getSpeed();
            default:
                return null;
        }
    }
}
