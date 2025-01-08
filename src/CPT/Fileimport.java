package CPT;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.chart.XYChart;

public class Fileimport {

    private FileChooser fileChooser;

    public void FileImporter() {
        fileChooser = new FileChooser();
        fileChooser.setTitle("Select CSV");
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("CSV Files", "*.csv"));
    }

    public File chooseFile(Stage stage) {
        return fileChooser.showOpenDialog(stage);
    }

    public String[] readCSV(File file, List<XYChart.Data<Number, Number>> dataPoints) throws IOException {
        String[] axisTitles = new String[]{"X-Axis", "Y-Axis"}; // Default axis titles
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;

            // Read the first row for axis titles
            if ((line = reader.readLine()) != null) {
                axisTitles = line.split(",");
            }

            // Read the remaining rows for data points
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 2) {
                    try {
                        double x = Double.parseDouble(parts[0]);
                        double y = Double.parseDouble(parts[1]);
                        dataPoints.add(new XYChart.Data<>(x, y));
                    } catch (NumberFormatException ex) {
                        System.err.println("Skipping invalid row: " + line);
                    }
                }
            }
        }
        return axisTitles;
    }
}
