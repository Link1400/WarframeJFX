package CPT;

import java.util.ArrayList;

public class weaponSearch {

    // Initializing search and array variables
    private String search;
    private ArrayList<MeleeWeapon> originallist;

    /**
     * Constructor for the search class
     * 
     * @param search       the search inputted into the textbox
     * @param originallist the array variable for searching through it
     */
    public weaponSearch(String search, ArrayList<MeleeWeapon> originallist) {
        this.search = search;
        this.originallist = originallist;
    }

    /**
     * A method to search through an array, uses a for each loop to iterate through
     * the array, using the getFieldValue method and then using a custom
     * method substring search to search through each name for a match
     * 
     * @param field the field variable which helps distinguish between name of
     *              weapon and its weapon class for searching
     * @return returns an array with the results of the search
     */
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

    /**
     * A method which gets the search from user and name or class of an object and
     * then compares both using a for loop
     * and the string method charAt, it uses a boolean to see if the 2 strings match
     * with each letter
     * 
     * @param fieldValue a variable which stores the name or weapon class of an
     *                   object
     * @param stringIN   a variable containing weapon the user is searching for
     * @return returns true if the search matches with the name and false if they do
     *         not match
     */
    private boolean substrSearch(String fieldValue, String stringIN) {
        int fieldValueLength = fieldValue.length();
        int stringINLength = stringIN.length();
        {
            if (stringINLength == 0) {
                return true;
            }

            for (int arrayListiterate = 0; arrayListiterate <= fieldValueLength - stringINLength; arrayListiterate++) {
                boolean match = true;
                for (int chariterate = 0; chariterate < stringINLength; chariterate++) {
                    if (fieldValue.charAt(arrayListiterate + chariterate) != stringIN.charAt(chariterate)) {
                        match = false;
                        break;
                    }
                }
                if (match) {
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * A method to set the search
     * 
     * @param newSearch the search value
     */
    public void setSearch(String newSearch) {
        search = newSearch.toLowerCase();
    }

    /**
     * A getter method to return the search
     * 
     * @return the variable search which contains the string a user is searching
     */
    public String getSearch() {
        return search;
    }

    /**
     * Sets the array to search through
     * 
     * @param newList the array that is going to be searched through
     */
    public void setArray(ArrayList<MeleeWeapon> newList) {
        originallist = newList;
    }

    /**
     * Returns the array that will be searched
     * 
     * @return the array that will be searched
     */
    public ArrayList<MeleeWeapon> getArray() {
        return originallist;
    }

    /**
     * A method that uses switch case to return the properties of an object such as
     * its name or its weapon class
     * 
     * @param weapon variable which takes an object, it is used along side the
     *               getter methods to return the weapon name or weapon class
     * @param field  variable field which is used in the switch case to either
     *               return name or weapon class of object
     * @return
     */
    private String getFieldValue(MeleeWeapon weapon, String field) {
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