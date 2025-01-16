package CPT;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Display extends Application {
    private TableView<MeleeWeapon> tableView;
    private ArrayList<MeleeWeapon> originalWeapons; 
   
    
    
    private File defaultFile = new File("src/CPT/CSV File/melee.csv");
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws IOException {
        TabPane tabpane = new TabPane();
        
       
        
        // UI setup
        tableView = new TableView<>();
        JFXTable.setupTableColumns(tableView);
        Fileimport defaultFileimport = new Fileimport();
        ArrayList<MeleeWeapon> defaultweapons = defaultFileimport.readCSV(defaultFile);
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
        weaponSort sortbyClass = new weaponSort(defaultweapons);
        ArrayList<MeleeWeapon> weaponsbyClass = sortbyClass.insertionSortbyClass(defaultweapons);
        PieChart weaponclasspieChart = sortbyClass.countinstanceofClass(weaponsbyClass);


        ComboBox<String> sortSelector = new ComboBox<>();
        sortSelector.getItems().addAll("Impact", "Puncture", "Slash", "Base Damage", "Total Damage", "Critical Hit Chance", "Critical Hit Multiplier", "Status Effect Chance", "Attack Speed");
        Button sortConfirm = new Button("Sort");
        Button searchConfirm = new Button("Search");
        Button resetChart = new Button("Reset");
        weaponSort sortbydmg = new weaponSort(defaultweapons);
        ArrayList<MeleeWeapon> speedvdmg = sortbydmg.insertionSort(defaultweapons, "Base Damage");
        NumberAxis XAxis = new NumberAxis();
        NumberAxis YAxis = new NumberAxis();
        XAxis.setLabel("Attack Damage");
        YAxis.setLabel("Attack Speed");
        LineChart<Number, Number> lineChart = new LineChart<>(XAxis, YAxis);
        lineChart.setTitle("Attack Speed vs Base Damage");
        XYChart.Series<Number, Number> Data = new XYChart.Series<>();
        
        for(MeleeWeapon weapon : speedvdmg){
            double speedIN = weapon.getSpeed();
            double basedmgIN = weapon.getBaseDamage();
            Data.getData().add(new XYChart.Data<>(basedmgIN, speedIN));

        }
        lineChart.getData().addAll(Data);
        

        
        
       
       
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
                ArrayList<MeleeWeapon> filteredWeapons = searcher.searchArray(selectedField); 
                tableView.getItems().setAll(filteredWeapons); 
            }
            }
            
            
            );

            resetChart.setOnAction(e -> {
                tableView.getItems().setAll(originalWeapons); 
            });

        sortConfirm.setOnAction(e -> {
            System.out.println(sortSelector.getValue());
            weaponSort sort = new weaponSort(defaultweapons);
            String selectedSortField = sortSelector.getValue();
            ArrayList<MeleeWeapon> sortedWeapons = defaultweapons;
                for (MeleeWeapon weapon : sortedWeapons) {
                    sortedWeapons = sort.insertionSort(defaultweapons, selectedSortField);
                    
            
                 }
                 tableView.getItems().setAll(sortedWeapons);
                 
    });

        Label searchLabel = new Label("Search Data");
        Label sortLabel = new Label("Sort Data");

        HBox sortControls = new HBox(10, sortLabel, sortSelector, sortConfirm);
        HBox searchControls = new HBox(10, searchLabel, searchSelector, searchbox, searchConfirm, resetChart);
        HBox controlStrip = new HBox(10, sortControls, searchControls);
        controlStrip.setAlignment(Pos.CENTER);
        VBox layout = new VBox(20,  tableView,  controlStrip);
        layout.setAlignment(Pos.CENTER);
        VBox.setVgrow(tableView, Priority.ALWAYS);
        Label importInfo = new Label("Click this button to open the OS file picker");        
        Label importInfosub = new Label("The file must contain the same fields as the original to be valid");
        VBox importer = new VBox(10, importInfo, importInfosub, importCSV);
        importer.setAlignment(Pos.CENTER);
        Label welcome = new Label("Welcome to the Warframe Melee Weapon Data Viewer!");
        welcome.setFont(new Font("Arial Black", 25));
        Label welcome2 = new Label("This program will visualize the many statistics of Melee Weapons in Warframe in a clear and readable manner");
        welcome2.setFont(new Font("Arial", 15));
        Label welcome3 = new Label("Click a tab above to see the contents within");
        welcome3.setFont(new Font("Arial", 15));

        VBox Welcome = new VBox(10, welcome, welcome2, welcome3);
        Welcome.setAlignment(Pos.CENTER);
        
        VBox Linechartview = new VBox(10, lineChart);

        VBox Piechartview = new VBox(10, weaponclasspieChart);

        Tab dataViewerTab = new Tab("Data Viewer", layout);
        dataViewerTab.setClosable(false);
        Tab dataImporter = new Tab("Change CSV", importer );
        dataImporter.setClosable(false);
        Tab WelcomeScreen = new Tab("Welcome", Welcome);
        WelcomeScreen.setClosable(false);
        Tab PieChartViewTab = new Tab("Pie Chart", Piechartview);
        PieChartViewTab.setClosable(false);
        Tab LineChartViewTab = new Tab("Line Chart", Linechartview);
        LineChartViewTab.setClosable(false);

        tabpane.getTabs().addAll(WelcomeScreen, dataViewerTab, PieChartViewTab, LineChartViewTab, dataImporter);
        
        Scene scene = new Scene(tabpane, 1200, 600);
        stage.setScene(scene);
        stage.setTitle("Warframe Melee Weapon Data Viewer");
        stage.show();
    }
}
