package game.scenes;

public class SceneManager {

    //Singleton pattern - static instance of itself
    private static SceneManager sceneManager = new SceneManager();
    public static SceneManager getSceneManager() {
        return sceneManager;
    }

    //Scenes
    private Game gameScene;
    private GameLoop gameLoop;
    private GameOver gameOver;
    private Highscore highscore;
    private MainMenu mainMenu;

    // Singleton pattern - private constructor
    private SceneManager() {
        this.gameScene = new Game();
        this.gameLoop = new GameLoop();
        this.gameOver = new GameOver();
        this.highscore = new Highscore();
        this.mainMenu = new MainMenu();
    }

    //Getters
    public Game getGameScene() {
        return this.gameScene;
    }

    public GameLoop getGameLoop() {
        return  this.gameLoop;
    }

    public GameOver getGameOver() {
        return this.gameOver;
    }

    public Highscore getHighscore() {
        return this.highscore;
    }

    public MainMenu getMainMenu() {
        return this.mainMenu;
    }
}
