package game.scenes;

import game.characters.SwingCopter;
import game.control.LastScore;
import game.control.ScoreManager;
import game.obstacles.Tourniquet;
import game.stages.StageManager;
import game.world.City;
import game.world.Cloud;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.CacheHint;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Game extends Application {

   //FXML Objects
    @FXML private Text lifesText;
    @FXML private Text scoreText;

    //Game World Objects
    List<Cloud> clouds;
    List<Tourniquet> tourniquets;
    SwingCopter swingCopter;

    //Properties
    int score;
    int lifes;

    //Constructor
    public Game(int score, int lifes) {
        this.score = score;
        this.lifes = lifes;
        System.out.println(score);
    }

    @Override
    public void start(Stage mainStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/layouts/game.fxml"));
        loader.setController(this);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);

        //Removes texts that will be added later to simulate missing z-index property
        root.getChildren().remove(lifesText);
        root.getChildren().remove(scoreText);

        //World objects
        root.getChildren().add(City.getCity());
        clouds = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            clouds.add(new Cloud());
        }
        root.getChildren().addAll(clouds);
        tourniquets = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            tourniquets.add(new Tourniquet());
        }
        root.getChildren().addAll(tourniquets);

        //Characters
        swingCopter = SwingCopter.getSwingCopter();
        swingCopter.initialize(score,lifes);
        root.getChildren().add(swingCopter);

        //Adding texts to front of the scene
        root.getChildren().add(lifesText);
        root.getChildren().add(scoreText);

        //Mouse click handling
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                swingCopter.inverseVelocityX();
            }
        });

        //Game loop
        GameLoop gameLoop = SceneManager.getSceneManager().getGameLoop().initialize(tourniquets,clouds);
        gameLoop.start();

        mainStage.setScene(scene);
        mainStage.show();
    }

    //Receives notifications about objects state
    public void notify(String message) {
        if (message.equals("death")) {
            try {
                _reset();
                SceneManager.getSceneManager().getGameLoop().stop();
                SceneManager.getSceneManager().getGameOver().start(StageManager.getStageManager().getMainStage());
                SceneManager.getSceneManager().resetGame(0,0);
            }
            catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
        if (message.equals("life_lost")) {
            try {
                _reset();
                SceneManager.getSceneManager().getGameLoop().stop();
                SceneManager.getSceneManager().getDeathScene().start(StageManager.getStageManager().getMainStage());
                LastScore lastScore = ScoreManager.getScoreManager().getScore();
                SceneManager.getSceneManager().resetGame(lastScore.getScore(), lastScore.getLifes());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    //Updates score and life indicator
    public void update() {
        SwingCopter swingCopter = SwingCopter.getSwingCopter();
        lifesText.setText("Extra life: " + swingCopter.getLifes());
        scoreText.setText(Integer.toString(swingCopter.getScore()));
    }

    //Resets game loop objects
    private void _reset() {
        Tourniquet.resetYIndex();
        City.getCity().resetCity();
    }

}
