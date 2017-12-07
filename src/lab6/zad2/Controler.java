package lab6.zad2;

import javafx.application.Application;
import javafx.stage.Stage;


public class Controler extends Application {
   public Model m=new Model();
   public View v=new View();

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        v.m=m;
        v.menu(primaryStage);
    }
    }
