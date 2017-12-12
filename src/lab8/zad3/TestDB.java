package lab8.zad3;


import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class TestDB extends Application{
    DB db=new DB();
    Button btnscene1, btnscene2, btn3, btn4, btn5;
    GridPane pane1, pane2, pane3;
    Scene scene1, scene2, scene3;
    Stage thestage;
    public static void main(String []args){
        launch(args);
    }
    public void ButtonClicked(ActionEvent e)
    {
        if (e.getSource()==btnscene1)
            thestage.setScene(scene2);
        else
            thestage.setScene(scene1);
    }


    @Override
    public void start(Stage primaryStage) throws Exception {
        thestage=primaryStage;
        btnscene1=new Button("Szukaj");
        btnscene2=new Button("Powrót");
        btn3=new Button("Dodaj");
        btn4=new Button("Wyszukaj");
        btn5=new Button("Dodaj");
        btnscene1.setOnAction(e-> ButtonClicked(e));
        btnscene2.setOnAction(e-> ButtonClicked(e));
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                thestage.setScene(scene3);
            }
        });
        HBox hbBtn1 = new HBox(10);
        HBox hbBtn2 = new HBox(10);
        HBox hbBtn3=new HBox(10);
        hbBtn3.setAlignment(Pos.TOP_LEFT);
        hbBtn1.setAlignment(Pos.TOP_LEFT);
        hbBtn2.setAlignment(Pos.TOP_LEFT);
        hbBtn1.getChildren().add(btnscene1);
        hbBtn1.getChildren().add(btn3);
        hbBtn2.getChildren().add(btnscene2);
        hbBtn2.getChildren().add(btn4);
        hbBtn3.getChildren().add(btn5);
        pane1=new GridPane();
        pane2=new GridPane();
        pane3=new GridPane();
        pane1.setHgap(10);
        pane1.setVgap(10);
        pane1.setPadding(new Insets(25, 25, 25, 25));

        pane3.setHgap(10);
        pane3.setVgap(10);
        pane3.setPadding(new Insets(25, 25, 25, 25));

        Text actiontarget = new Text();
        Text target = new Text();
        pane2.add(actiontarget, 1, 6);
        pane3.add(target,1,6);
        pane2.setHgap(10);
        pane2.setVgap(10);
        pane2.setPadding(new Insets(25, 25, 25, 25));
        Label prob = new Label("Szukana fraza");
        pane2.add(prob, 0, 3);

        Label isbn_text = new Label("ISBN:");
        pane3.add(isbn_text, 0, 1);
        TextField isbn=new TextField();
        pane3.add(isbn,1,1);

        Label aut_text = new Label("Autor:");
        pane3.add(aut_text, 0, 2);
        TextField author=new TextField();
        pane3.add(author,1,2);

        Label title_text = new Label("Tytuł: ");
        pane3.add(title_text, 0, 3);
        TextField title=new TextField();
        pane3.add(title,1,3);

        Label year_text = new Label("Rok:");
        pane3.add(year_text, 0, 4);

        TextField year=new TextField();
        pane3.add(year,1,4);
        btn5.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                db.connect();
                db.add(isbn.getText(),title.getText(),author.getText(),year.getText());
                target.setText("Dodano książkę");

            }
        });
        TextField fraza = new TextField();
        pane2.add(fraza, 1, 3);
        btn4.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                db.connect();
                db.search(fraza.getText());
                actiontarget.setText("Wyszukane książki:\n"+db.wynik);
            }
        });
        pane1.add(hbBtn1,1,1);
        pane2.add(hbBtn2,1,1);
        pane3.add(hbBtn3,1,5);
        scene1 = new Scene(pane1, 500, 300);
        scene2 = new Scene(pane2, 500, 300);
        scene3 = new Scene(pane3, 500, 300);
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene1);
        primaryStage.show();

    }
}