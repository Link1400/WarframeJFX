package CPT;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class Display extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) {
        // UI setup
        Button importCSV = new Button("Import Melee Weapon Data");

        VBox layout = new VBox(10, importCSV);

        // File importer
        Fileimport fileImporter = new Fileimport();
        importCSV.setOnAction(e -> {
            File file = fileImporter.chooseFile(stage);
            if (file != null) {
                try {
                    List<MeleeWeapon> weapons = fileImporter.readCSV(file);

                    // Display each weapon
                    for (MeleeWeapon weapon : weapons) {
                        System.out.println(weapon);
                    }
                } catch (IOException ex) {
                    System.err.println("Error reading file: " + ex.getMessage());
                }
            }
        });

        // Scene and Stage
        Scene scene = new Scene(layout, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Melee Weapon Viewer");
        stage.show();
    }
}
