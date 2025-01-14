package CPT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

@Deprecated 

public class test {
    public static void main(String[] args) throws IOException {
        Fileimport defaultFileimport = new Fileimport();
        File defaultFile = new File("src/CPT/CSV File/melee.csv");
        ArrayList<MeleeWeapon> defaultweapons = (ArrayList<MeleeWeapon>) defaultFileimport.readCSV(defaultFile);
        weaponSort gay = new weaponSort(defaultweapons);
        ArrayList<MeleeWeapon> gayweapons = gay.insertionSort(defaultweapons, "Base Damage");
        for (MeleeWeapon yo : gayweapons) {
            System.out.println(yo.getBaseDamage());
        }
    }

    /* DEPRECATED TEST METHOD
    public static void insertionSort(ArrayList<MeleeWeapon> array) {
        for (int i = 1; i < array.size(); i++) {
            MeleeWeapon weapon = array.get(i);
            Double dmg = weapon.getBaseDamage();
            int selectedDmg = i - 1;
            
            while (selectedDmg >= 0 && array.get(selectedDmg).getBaseDamage() > dmg) {
                array.set(selectedDmg + 1, array.get(selectedDmg));
                selectedDmg--;
            }
            array.set(selectedDmg + 1, weapon);
        }
    }*/
}
