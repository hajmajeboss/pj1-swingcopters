package game;

import game.scenes.SceneManager;
import game.stages.StageManager;
import javafx.application.Application;
import javafx.stage.Stage;

public class Main extends Application {

    public static void main(String[] args) {launch(args);}

    @Override
    public void start(Stage mainStage) throws Exception{
        StageManager.getStageManager().setMainStage(mainStage);
        SceneManager.getSceneManager().getMainMenu().start(mainStage);
    }
}
