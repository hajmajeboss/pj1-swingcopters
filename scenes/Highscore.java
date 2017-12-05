package game.scenes;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Highscore extends Application {

    private static Highscore ourInstance = new Highscore();
    public static Highscore getHighscore() {
        return ourInstance;
    }
    public  Highscore() {}

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/highscore.fxml"));
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
    }

    @FXML
    public void onBackButtonPressed() throws Exception {
        MainMenu.getMainMenu().start(Main.getPrimaryStage());
    }
}
