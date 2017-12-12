package game.scenes;

import game.control.DatedScore;
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

public class Highscore extends Application {

    @FXML private Text scoreText;
    @FXML private Text dateText;

    public  Highscore() {}

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/layouts/highscore.fxml"));
        loader.setController(this);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);

        DatedScore highscore = ScoreManager.getScoreManager().getHighScore();
        scoreText.setText("Score: " + highscore.getScore());
        dateText.setText("Date: " + highscore.getDate());
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Will be run after Back button is pressed
    //@throws Exception
    @FXML
    public void onBackButtonPressed() throws Exception {
        SceneManager.getSceneManager().getMainMenu().start(StageManager.getStageManager().getMainStage());
    }
}
