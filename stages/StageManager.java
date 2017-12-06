package game.stages;

import javafx.stage.Stage;

public class StageManager {
    //Singleton pattern - static instances of itself
    private static StageManager stageManager = new StageManager();
    public static StageManager getStageManager() { return stageManager; }

    //Stages
    private Stage mainStage;

    //Singleton pattern - private constructor
    private StageManager() { }

    //Setters
    public void setMainStage(Stage mainStage) {
        this.mainStage = mainStage;
        this.mainStage.setTitle("FX Copters");
    }

    //Getters
    public Stage getMainStage() {
        return this.mainStage;
    }
}
