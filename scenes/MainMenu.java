package game.scenes;

import game.control.SoundManager;
import game.stages.StageManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.media.MediaPlayer;
import javafx.stage.Stage;

public class MainMenu extends Application{

    public MediaPlayer splash;

    public MainMenu() {
        splash = SoundManager.getSoundManager().getSplash();
        splash.setCycleCount(MediaPlayer.INDEFINITE);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/mainmenu.fxml"));
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
        splash.play();
    }

    //WIll be run after Play button is pressed
    //@throws Exception
    @FXML
    public void onPlayButtonPressed() throws Exception {
        SceneManager.getSceneManager().getGameScene().start(StageManager.getStageManager().getMainStage());
        splash.stop();
    }

    //Will be run after Highscore button is pressed
    //@throws Exception
    @FXML
    public void onScoreButtonPressed() throws Exception {
        SceneManager.getSceneManager().getHighscore().start(StageManager.getStageManager().getMainStage());
    }

    //Will be run after Exit button is pressed
    //@throws Exception
    @FXML
    public void onExitButtonPressed() throws Exception {
        StageManager.getStageManager().getMainStage().close();
        splash.stop();
    }
}
