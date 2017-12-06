package game.scenes;

import game.stages.StageManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOver extends Application {

    public GameOver() { }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/gameover.fxml"));
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
    }


    //Will be run after Main Menu button is pressed
    //@throws Exception
    @FXML
    public void onMainMenuButtonPressed() throws Exception{
        SceneManager.getSceneManager().getMainMenu().start(StageManager.getStageManager().getMainStage());
    }

    //Will be run after Exit button is pressed
    //@throws Exception
    @FXML
    public void onExitButtonPressed() throws Exception {
        StageManager.getStageManager().getMainStage().close();
    }
}
