package game.scenes;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    private static Stage primaryStage;

    public static Stage getPrimaryStage() {
        return primaryStage;
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Main.primaryStage = primaryStage;
        primaryStage.setTitle("Swing Copters");
        //primaryStage.setResizable(false);
        MainMenu.getMainMenu().start(primaryStage);
    }

    public static void main(String[] args) {
        launch(args);
    }

}
