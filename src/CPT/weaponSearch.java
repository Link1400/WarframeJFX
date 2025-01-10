package CPT;
import java.util.ArrayList;

public class weaponSearch {

    private String search;
    private String[] array;

    public weaponSearch(String search, String[] array) {
        this.search = search;
        this.array = array;
    }

    public ArrayList<String> searchArray(String search, String[] list) {
        ArrayList<String> foundSearch = new ArrayList<>();
        for (String value : list) {
            if (value.startsWith(search)) {
                foundSearch.add(value);
            }
        }
        return foundSearch;
    }

    public void setSearch(String newSearch) {
        search = newSearch;
    }

    public String getSearch() {
        return search;
    }

    public void setArray(String[] newArray) {
        array = newArray;
    }
    
    public String[] getArray() {
        return array;
    }

    public ArrayList<String> search() {
        return searchArray(search, array);
    }

}