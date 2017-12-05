package game.scenes;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class GameOver extends Application {

    private static GameOver ourInstance = new GameOver();
    public static GameOver getGameOver() {
        return ourInstance;
    }
    public GameOver() { }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/gameover.fxml"));
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
    }

    @FXML
    public void onMainMenuButtonPressed() throws Exception{
        MainMenu.getMainMenu().start(Main.getPrimaryStage());
    }

    @FXML
    public void onExitButtonPressed() throws Exception {
        Main.getPrimaryStage().close();
    }
}
