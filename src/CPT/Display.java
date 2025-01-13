package CPT;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Display extends Application {
    private TableView<MeleeWeapon> tableView;
    private ArrayList<MeleeWeapon> originalWeapons; // Store the full list for reset functionality
    
    private File defaultFile = new File("src/CPT/CSV File/melee.csv");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        // UI setup
        tableView = new TableView<>();
        JFXTable.setupTableColumns(tableView);
        Fileimport defaultFileimport = new Fileimport();
        List<MeleeWeapon> defaultweapons = defaultFileimport.readCSV(defaultFile);
        originalWeapons = new ArrayList<>(defaultweapons);
        for (MeleeWeapon weapon : defaultweapons) {
                        
            tableView.refresh();
            System.out.println(weapon);
            tableView.getItems().setAll(defaultweapons); // Populate the TableView
            tableView.refresh(); // Ensure the TableView updates
        }
        Button importCSV = new Button("Import Melee Weapon Data");
        TextField searchbox = new TextField();
        searchbox.setPromptText("Search...");
        ComboBox<String> searchSelector = new ComboBox<>();
        searchSelector.getItems().addAll("Name", "Weapon Class");
        searchSelector.setValue("Name");
        Button searchConfirm = new Button("Search");
        Button resetChart = new Button("Reset");
         
        
       
       
        // File importer
        Fileimport fileImporter = new Fileimport();
        importCSV.setOnAction(e -> {
            File file = fileImporter.chooseFile(stage);
            if (file != null) {
                try {
                    List<MeleeWeapon> weapons = fileImporter.readCSV(file); 

                    // Display each weapon
                    for (MeleeWeapon weapon : weapons) {
                        
                        tableView.refresh();
                        System.out.println(weapon);
                        tableView.getItems().setAll(weapons); 
                        tableView.refresh(); 
                    }
                } catch (IOException ex) {
                    System.err.println("Error reading file: " + ex.getMessage());
                }
            }
        });

        searchConfirm.setOnAction(e -> {
            String searchTermoriginal = searchbox.getText();
            String selectedField = searchSelector.getValue();
            String searchTermLower = searchTermoriginal.toLowerCase();
            System.out.println(searchTermLower);
            if (!searchTermLower.isEmpty()){
                weaponSearch searcher = new weaponSearch(searchTermLower, originalWeapons);
                ArrayList<MeleeWeapon> filteredWeapons = searcher.searchArray(selectedField); // Call performSearch()
                tableView.getItems().setAll(filteredWeapons); // Update the TableView
            }
            }
            
            
            );

            resetChart.setOnAction(e -> {
                tableView.getItems().setAll(originalWeapons); // Reset to original list
            });

        
        HBox searchControls = new HBox(10, searchSelector, searchbox, searchConfirm, resetChart);
        VBox layout = new VBox(20, tableView,  searchControls, importCSV);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        
        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Warframe Melee Weapon Data Viewer");
        stage.show();
    }
}
