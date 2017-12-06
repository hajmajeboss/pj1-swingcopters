package game.scenes;

import game.stages.StageManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Highscore extends Application {

    public  Highscore() {}

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/highscore.fxml"));
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
    }

    //Will be run after Back button is pressed
    //@throws Exception
    @FXML
    public void onBackButtonPressed() throws Exception {
        SceneManager.getSceneManager().getMainMenu().start(StageManager.getStageManager().getMainStage());
    }
}
