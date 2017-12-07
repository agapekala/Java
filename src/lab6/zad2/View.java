package lab6.zad2;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class View {
    public Model m=new Model();
    public void menu(Stage s){
       s.setTitle("Wielomiany");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(25, 25, 25, 25));

        Scene scene = new Scene(grid, 600, 275);
        s.setScene(scene);

        Label wsp = new Label("Współczynniki\noddzielone\nprzecinkami");
        grid.add(wsp, 0, 1);

        TextField wspTextField = new TextField();
        grid.add(wspTextField, 1, 1);

        Label zakres = new Label("Zakres");
        grid.add(zakres, 0, 2);

        TextField odTextField = new TextField();
        grid.add(odTextField, 1, 2);

        TextField doTextField = new TextField();
        grid.add(doTextField, 2, 2);

        Label prob = new Label("Próbkowanie");
        grid.add(prob, 0, 3);

        TextField probTextField = new TextField();
        grid.add(probTextField, 1, 3);

        Button btn = new Button("Rysuj");
        HBox hbBtn = new HBox(10);
        hbBtn.setAlignment(Pos.BOTTOM_RIGHT);
        hbBtn.getChildren().add(btn);
        grid.add(hbBtn, 1, 4);

        final Text actiontarget = new Text();
        grid.add(actiontarget, 1, 6);

        btn.setOnAction(new EventHandler<ActionEvent>() {

            @Override
            public void handle(ActionEvent e) {
                m.od_=odTextField.getText();
                m.do_=doTextField.getText();
                m.wsp_=wspTextField.getText();
                m.prob_=probTextField.getText();
                m.probToNum();
                m.wspToNum();
                m.zakresToNum();
                chartWin();
            }
        });
        s.show();
    }
    public void chartWin() {
        Stage stage=new Stage();
        final NumberAxis xAxis = new NumberAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("x");
        final LineChart<Number, Number> lineChart =
                new LineChart<Number, Number>(xAxis, yAxis);

        lineChart.setTitle("Wykres wielomianu");
        XYChart.Series series = new XYChart.Series();
        for(double i=m.od_num;i<=m.do_num; i+=m.prob_num){
            series.getData().add(new XYChart.Data(i, m.policzWart(i)));
        }


        Scene scene = new Scene(lineChart, 800, 600);
        lineChart.getData().add(series);

        stage.setScene(scene);
        stage.show();
        m=new Model();
    }
}

