package CPT;


import java.util.ArrayList;
import java.util.List;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import javafx.scene.layout.VBox;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.*;
// test

public class Display extends Application{
    public static void main(String[] args) {
         
        launch(args);
    }
    
    public void start(Stage stage){
        NumberAxis xAxis = new NumberAxis();
        NumberAxis yAxis = new NumberAxis();
        NumberAxis xAxis2 = new NumberAxis();
        NumberAxis yAxis2 = new NumberAxis();
        Button importCSV = new Button("Import");
        Button clr = new Button("Clear");
        LineChart<Number, Number> lineChart = new LineChart<>(xAxis, yAxis);
        xAxis.setLabel("Item 1");
        yAxis.setLabel("Item 2");
        
        lineChart.setTitle("a graph");
        XYChart.Series<Number, Number> series = new XYChart.Series<>();
        XYChart.Series<Number, Number> series2 = new XYChart.Series<>();
        
        

        lineChart.getData().add(series);
        

        StackPane chartPane = new StackPane();
        chartPane.getChildren().add(lineChart);


        VBox thing = new VBox(10, chartPane, importCSV, clr);

        Scene scene = new Scene(thing, 800, 600);
        stage.setScene(scene);
        stage.setTitle("Line chart importing data from csv file");
        stage.show(); // Removed unnecessary semicolon
        };
    }

        