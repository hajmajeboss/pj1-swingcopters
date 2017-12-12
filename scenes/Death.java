package game.scenes;

import game.control.ScoreManager;
import game.stages.StageManager;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Death extends Application {

    @FXML private Text scoreText;
    @FXML private Text lifesText;

    public Death() { }

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/layouts/death.fxml"));
        loader.setController(this);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setScene(scene);
        primaryStage.show();

        scoreText.setText("Score: " + ScoreManager.getScoreManager().getScore().getScore());
        lifesText.setText("Extra life: " + ScoreManager.getScoreManager().getScore().getLifes());

    }


    //Will be run after Continue button is pressed
    @FXML
    public void onContinueButtonPressed() throws Exception{
        SceneManager.getSceneManager().getGameScene().start(StageManager.getStageManager().getMainStage());
    }

}
