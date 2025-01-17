package CPT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

public class Fileimport {

    // Initializing the file chooser variable
    private static FileChooser fileChooser;

    /**
     * A window which allows you to pick csv files to input into the table
     */
    public Fileimport() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Select CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
    }

    public File chooseFile(Stage stage) {
        return fileChooser.showOpenDialog(stage);
    }

    /**
     * A method to read a csv file, retrieves all the data in the csv file by using
     * the string split method and making a parts table, it then
     * makes variables for each value of data and then makes a new object from the
     * weapon class with all of the values
     * 
     * @param file
     * @return
     * @throws IOException
     */
    public ArrayList<MeleeWeapon> readCSV(File file) throws IOException {
        ArrayList<MeleeWeapon> weapons = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            boolean isFirstLine = true;

            // Skip header row
            while ((line = reader.readLine()) != null) {
                if (isFirstLine) {
                    isFirstLine = false;
                    continue;
                }

                String[] parts = line.split(",");
                // Ensure all columns are present in the csv file by checking its length
                if (parts.length >= 14) {
                    try {
                        String name = parts[0];
                        String attackName = parts[1];
                        double impact = Double.parseDouble(parts[2]);
                        double puncture = Double.parseDouble(parts[3]);
                        double slash = Double.parseDouble(parts[4]);
                        double baseDamage = Double.parseDouble(parts[5]);
                        double totalDamage = Double.parseDouble(parts[6]);
                        double critChance = Double.parseDouble(parts[7]);
                        double critMultiplier = Double.parseDouble(parts[8]);
                        double statusChance = Double.parseDouble(parts[9]);
                        double speed = Double.parseDouble(parts[10]);
                        int mastery = Integer.parseInt(parts[11]);
                        String introducedDate = parts[12];
                        String weaponClass = parts[13];

                        // Create a new MeleeWeapon object
                        MeleeWeapon weapon = new MeleeWeapon(name, attackName, impact, puncture, slash, baseDamage,
                                totalDamage, critChance, critMultiplier, statusChance,
                                speed, mastery, introducedDate, weaponClass);
                        weapons.add(weapon);
                    } catch (NumberFormatException ex) {
                        System.err.println("Skipping invalid row: " + line);
                    }
                }
            }
        }
        return weapons;
    }
    /*
     * public List<MeleeWeapon> loadDefaultCSV(){
     * if(!defaultFile.exists()){
     * System.out.println("Default file not found, skipping");
     * return new ArrayList<>();
     * 
     * }
     * 
     * try {
     * return readCSV(defaultFile);
     * } catch (IOException e) {
     * System.out.println("Default file read error, skipping");
     * return new ArrayList<>();
     * 
     * }
     * }
     * Deprecated
     */
}