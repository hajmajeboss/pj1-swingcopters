package game.control;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class SoundManager {

    //Singleton pattern - instance of itself
    private static SoundManager soundManager = new SoundManager();
    public static SoundManager getSoundManager() {return soundManager;}

    //Constants
    private String WORKSPACE_PATH = "file:///"  + System.getProperty("user.dir").replace("\\", "/");

    //Sounds
    MediaPlayer splash;
    MediaPlayer coinCollect;
    MediaPlayer heartCollect;
    MediaPlayer fail;
    MediaPlayer success;
    MediaPlayer lifeLost;

    //Singleton pattern - private constructor
    private SoundManager() {
        System.out.println(System.getProperty("user.dir"));
        splash = new MediaPlayer(new Media(WORKSPACE_PATH + "/src/game//res/sounds/splash.mp3"));
        coinCollect = new MediaPlayer(new Media(WORKSPACE_PATH + "/src/game//res/sounds/coin.wav"));
        heartCollect = new MediaPlayer(new Media(WORKSPACE_PATH + "/src/game//res/sounds/heal.wav"));
        fail = new MediaPlayer(new Media(WORKSPACE_PATH + "/src/game//res/sounds/fail.mp3"));
        success = new MediaPlayer(new Media(WORKSPACE_PATH + "/src/game//res/sounds/success.wav"));
        lifeLost = new MediaPlayer(new Media(WORKSPACE_PATH + "/src/game//res/sounds/lifelost.wav"));
    }

    //Getters
    public MediaPlayer getCoinCollect() {
        return coinCollect;
    }

    public MediaPlayer getFail() {
        return fail;
    }

    public MediaPlayer getHeartCollect() {
        return heartCollect;
    }

    public MediaPlayer getLifeLost() {
        return lifeLost;
    }

    public MediaPlayer getSplash() {
        return splash;
    }

    public MediaPlayer getSuccess() {
        return success;
    }
}
