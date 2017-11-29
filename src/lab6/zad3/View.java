package lab6.zad3;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;

import java.io.File;
import java.util.LinkedList;
import java.util.Map;
public class View {
    public LinkedList<String> list=new LinkedList<>();

    public void firstWin(Stage s, Model k){final DirectoryChooser dirChooser = new DirectoryChooser();
        Button button=new Button("Wybierz folder");
        button.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event1) {
                String path="";
                File selectedDirectory =
                        dirChooser.showDialog(s);

                if(selectedDirectory != null) {
                    path=selectedDirectory.getPath();
                }
                secondWin(path, k);
            }
        });
        Pane root = new Pane();
        root.getChildren().add(button);
        s.setScene(new Scene(root, 200, 100));
        s.show();}

    public void secondWin(String dir_path, Model k){

        Stage stage=new Stage();
        BorderPane root = new BorderPane();
        Scene scene = new Scene(root, 400, 250, Color.WHITE);
        GridPane gridpane = new GridPane();
        gridpane.setPadding(new Insets(5));
        gridpane.setHgap(10);
        gridpane.setVgap(10);
        ColumnConstraints column1 = new ColumnConstraints(150, 150,
                Double.MAX_VALUE);
        ColumnConstraints column2 = new ColumnConstraints(50);
        column1.setHgrow(Priority.ALWAYS);
        gridpane.getColumnConstraints().addAll(column1, column2);

        Label candidatesLbl = new Label("Zdjęcia");
        GridPane.setHalignment(candidatesLbl, HPos.CENTER);
        gridpane.add(candidatesLbl, 0, 0);

        try {
            k.direct(dir_path, list);
        }catch (Exception e) {
        }
        final ObservableList<String> candidates = FXCollections
                .observableArrayList(list);
        final ListView<String> candidatesListView = new ListView<>(candidates);
        gridpane.add(candidatesListView, 0, 1);


        Button sendRightButton = new Button(" > ");

        sendRightButton.setOnAction((ActionEvent event) -> {
            String potential = candidatesListView.getSelectionModel()
                    .getSelectedItem();
            if (potential != null) {
                candidatesListView.getSelectionModel().clearSelection();
                String p=dir_path+'/'+potential;
                try {
                    showImage(potential, dir_path,k.recognize(p));
                }catch(Exception e) {
                }
            }
        });

        VBox vbox = new VBox(5);
        vbox.getChildren().addAll(sendRightButton);

        gridpane.add(vbox, 1, 1);
        root.setCenter(gridpane);

        GridPane.setVgrow(root, Priority.ALWAYS);
        stage.setScene(scene);
        stage.show();
    }
    public void showImage(String name, String dir_path, Map<String,Double> mapa){
        Stage stage=new Stage();
        String img_path=dir_path+'/'+name;

        File file=new File(img_path);
        Image image=new Image(file.toURI().toString());

        ImageView iv1 = new ImageView();
        iv1.setImage(image);


        Group root = new Group();
        Scene scene = new Scene(root,800,600);
        iv1.setLayoutY(200);
        iv1.setLayoutX(10);
        scene.setFill(Color.WHEAT);
        root.getChildren().add(iv1);

        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList();



        for (Map.Entry<String, Double> entry : mapa.entrySet()) {
            if(entry.getValue()>0.05) {
                pieChartData.add(new PieChart.Data(entry.getKey(), entry.getValue()));
            }
        }


        final PieChart chart = new PieChart(pieChartData);
        chart.setTitle("Wykres");

        chart.setLayoutX(200);
        chart.setLayoutY(200);
        chart.setMaxSize(800,800);
        root.getChildren().add(chart);

        stage.setTitle("Tytuł");
        stage.setScene(scene);
        stage.sizeToScene();
        stage.show();

    }

}
