package game.scenes;

import game.control.ScoreManager;
import game.stages.StageManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class GameOver extends Application {

    @FXML private Text scoreText;
    @FXML private Text newHighScoreText;

    public GameOver() { }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/layouts/gameover.fxml"));
        loader.setController(this);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        scoreText.setText("Score: " + ScoreManager.getScoreManager().getScore().getScore());
        if (ScoreManager.getScoreManager().isNewHighscore()) {
            newHighScoreText.setVisible(true);
            ScoreManager.getScoreManager().setNewHighscore(false);
        }
        else {
            newHighScoreText.setVisible(false);
        }

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
