package CPT;
import java.util.ArrayList;

public class weaponSearch {

    private String search;
    private ArrayList<MeleeWeapon> originallist;

    public weaponSearch(String search, ArrayList<MeleeWeapon> originallist) {
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

private boolean substrSearch(String fieldValue, String stringIN ){
        int fieldValueLength = fieldValue.length();
        int stringINLength = stringIN.length();
        {
            if(stringINLength == 0){
                return true;
            }

            for(int arrayListiterate = 0; arrayListiterate <= fieldValueLength - stringINLength; arrayListiterate++ ){
                boolean match = true;
                for(int chariterate = 0; chariterate < stringINLength; chariterate++){
                    if(fieldValue.charAt(arrayListiterate+chariterate) != stringIN.charAt(chariterate)){
                        match = false;
                        break;
                    }
                }
                if(match){
                    return true;
                }
            }
        return false;
        }
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