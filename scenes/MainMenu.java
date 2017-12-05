package game.scenes;

import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class MainMenu extends Application{

    //Getters
    private static MainMenu ourInstance = new MainMenu();
    public static MainMenu getMainMenu() {
        return ourInstance;
    }

    //Singleton - had to use public constructor due to using FXML
    public MainMenu() { }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../res/layouts/mainmenu.fxml"));
        primaryStage.setScene(new Scene(root ));
        primaryStage.show();
    }

    //FXML Buttons Handlers
    @FXML
    public void onPlayButtonPressed() throws Exception {
        Game.getGameScene().start(Main.getPrimaryStage());
    }

    @FXML
    public void onScoreButtonPressed() throws Exception {
        Highscore.getHighscore().start(Main.getPrimaryStage());
    }

    @FXML
    public void onExitButtonPressed() throws Exception {
        Main.getPrimaryStage().close();
    }
}
