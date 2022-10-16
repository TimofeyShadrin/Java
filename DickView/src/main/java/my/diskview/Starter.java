package my.diskview;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import javafx.scene.input.*;
import java.io.File;
import java.nio.file.Path;
import java.util.Map;

public class Starter extends Application {
    private Stage stage;
    private Map<String, Long> sizes;
    private final ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList();
    protected PieChart pieChart;

    public static void main(String[] args) {
        //launch(args);
    }
    @Override
    public void start(Stage stage) {
        this.stage = stage;
        stage.setTitle("Disk analyzer");

        Button button = new Button("Choose directory");
        button.setOnAction(event -> {
            File file = new DirectoryChooser().showDialog(stage);
            String path = file.getAbsolutePath();
            sizes = new Analyzer().calculateDirSize(Path.of(path));
            buildChart(path);
        });

        StackPane pane = new StackPane();
        pane.getChildren().add(button);
        stage.setScene(new Scene(pane, 300, 250));
        stage.show();
    }

    private void buildChart(String path) {
        pieChart = new PieChart(pieChartData);

        refillChart(path);

        stage.setScene(new Scene(pieChart, 900, 600));
        stage.show();
    }

    private void refillChart(String path) {
        pieChartData.clear();
        pieChartData.addAll(
                sizes
                        .entrySet()
                        .parallelStream()
                        .filter(entry -> {
                            Path parent = Path.of(entry.getKey()).getParent();
                            return parent != null && parent.toString().equals(path);
                        })
                        .map(entry -> new PieChart.Data(entry.getKey(), entry.getValue())).toList()
        );
        pieChart.getData().forEach((data) -> data
                .getNode()
                .addEventHandler(
                        MouseEvent.MOUSE_PRESSED,
                        event -> refillChart(data.getName())
                ));
    }
}
