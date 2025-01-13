package CPT;
import java.util.ArrayList;

public class WeaponSearch {

    private String search;
    private ArrayList<MeleeWeapon> originallist;

    public WeaponSearch(String search, ArrayList<MeleeWeapon> originallist) {
        this.search = search;
        this.originallist = originallist;
    }

    public ArrayList<MeleeWeapon> searchArray() {
        ArrayList<MeleeWeapon> foundSearch = new ArrayList<>();
        for (MeleeWeapon weapon : originallist) {
            if (weapon.getName().toLowerCase().startsWith(search)) {
                foundSearch.add(weapon);
        }
    }
    return foundSearch;
}

    public void setSearch(String newSearch) {
        search = newSearch.toLowerCase();
    }

    public String getSearch() {
        return search;
    }

    public void setArray(ArrayList<MeleeWeapon> newList) {
        originallist = newList;
    }
    
    public ArrayList<MeleeWeapon> getArray() {
        return originallist;
    }

    
}