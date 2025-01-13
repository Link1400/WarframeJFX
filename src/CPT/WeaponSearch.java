package CPT;
import java.util.ArrayList;

public class WeaponSearch {

    private String search;
    private ArrayList<MeleeWeapon> originallist;

    public WeaponSearch(String search, ArrayList<MeleeWeapon> originallist) {
        this.search = search;
        this.originallist = originallist;
    }

    public ArrayList<MeleeWeapon> searchArray(String field) {
        ArrayList<MeleeWeapon> foundSearch = new ArrayList<>();
        for (MeleeWeapon weapon : originallist) {
            String fieldValue = getFieldValue(weapon, field);
            if (fieldValue != null && substrSearch(fieldValue.toLowerCase(), search.toLowerCase())) {
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

    private String getFieldValue(MeleeWeapon weapon, String field){
        switch (field) {
            case "Name":
                return weapon.getName();
            case "Weapon Class":
                return weapon.getWeaponClass();
            default:
                return null;
        }
    }

    
}