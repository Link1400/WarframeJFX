package CPT;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class test {
    public static void main(String[] args) throws IOException {
        Fileimport defaultFileimport = new Fileimport();
        File defaultFile = new File("src/CPT/CSV File/melee.csv");
        ArrayList<MeleeWeapon> defaultweapons = (ArrayList<MeleeWeapon>) defaultFileimport.readCSV(defaultFile);
        insertionSort(defaultweapons);
        for (MeleeWeapon yo : defaultweapons) {
            System.out.println(yo.getBaseDamage());
        }
    }

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
    }
}
