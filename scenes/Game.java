package game.scenes;

import game.characters.SwingCopter;
import game.world.Cloud;
import javafx.animation.AnimationTimer;
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
    private static Game gameInstance = new Game();
    public static Game getGameScene() {
        return gameInstance ;
    }

   //Singleton - had to use public constructor due to using FXML
    public Game() {}

    @FXML
    private Text lifesText;
    @FXML
    private Text scoreText;

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../res/layouts/game.fxml"));
        loader.setController(this);
        AnchorPane root = loader.load();
        Scene scene = new Scene(root);

        //Characters
        SwingCopter swingCopter = SwingCopter.getSwingCopter();
        swingCopter.initialize();
        root.getChildren().add(swingCopter);

        //World objects
        List<Cloud> clouds = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            clouds.add(new Cloud());
        }
        root.getChildren().addAll(clouds);

        //Mouse click handling
        scene.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                swingCopter.inverseVelocityX();
            }
        });

        //Game loop

        new AnimationTimer() {
            @Override
            public void handle(long now) {
                lifesText.setText("Lifes: " + swingCopter.getLifes());
                scoreText.setText("Score: " + swingCopter.getScore());
                for (Cloud cloud : clouds) {
                    cloud.move();
                }
                swingCopter.move();

            }
        }.start();

        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public static void notify(String message) {
        if (message.equals("death")) {
            try {
                System.out.println("death");
                GameOver.getGameOver().start(Main.getPrimaryStage());
            }
            catch (Exception e) {
                System.out.println("ex");
            }
        }
    }

}
