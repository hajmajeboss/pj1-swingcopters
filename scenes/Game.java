package game.scenes;

import game.characters.SwingCopter;
import game.obstacles.Tourniquet;
import game.stages.StageManager;
import game.world.City;
import game.world.Cloud;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
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

    //Constructor
    public Game() {}

    @Override
    public void start(Stage mainStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/layouts/game.fxml"));
        loader.setController(this);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);

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
        swingCopter.initialize();
        root.getChildren().add(swingCopter);

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
                SceneManager.getSceneManager().resetGame();
            }
            catch (Exception e) {
                System.out.println(e.getStackTrace());
            }
        }
    }

    //Updates score and life indicator
    public void update() {
        SwingCopter swingCopter = SwingCopter.getSwingCopter();
        lifesText.setText("Lifes: " + swingCopter.getLifes());
        scoreText.setText("Score: " + swingCopter.getScore());
    }

    //Resets game loop objects
    private void _reset() {
        Tourniquet.resetYIndex();
        City.getCity().resetCity();
    }
}
