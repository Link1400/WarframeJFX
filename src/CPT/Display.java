package CPT;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Display extends Application {
    private TableView<MeleeWeapon> tableView;
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
        for (MeleeWeapon weapon : defaultweapons) {
                        
            tableView.refresh();
            System.out.println(weapon);
            tableView.getItems().setAll(defaultweapons); // Populate the TableView
            tableView.refresh(); // Ensure the TableView updates
        }
        Button importCSV = new Button("Import Melee Weapon Data");
         
        
       
       
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
                        tableView.getItems().setAll(weapons); // Populate the TableView
                        tableView.refresh(); // Ensure the TableView updates
                    }
                } catch (IOException ex) {
                    System.err.println("Error reading file: " + ex.getMessage());
                }
            }
        });

        
        VBox layout = new VBox(20, tableView, importCSV);
        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Warframe Melee Weapon Data Viewer");
        stage.show();
    }
}
