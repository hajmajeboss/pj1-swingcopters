package game.characters;

import game.scenes.SceneManager;
import game.stages.StageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SwingCopter extends Pane {

    //Singleton pattern - static instance of itself
    private static SwingCopter swingCopterInstance= new SwingCopter();
    public static SwingCopter getSwingCopter() {
        return swingCopterInstance;
    }

    //Constants
    private static final int SWING_WIDTH = 51;
    private static final int SWING_HEIGHT = 53;
    private static final int DISTANCE_SWING_WINDOW = 100;

    //Images
    private ImageView swingCopter;
    private Image swingLeft;
    private Image swingRight;

    //Properties
    private double velocityX;
    private int lifes;
    private int score;

    //Singleton pattern - private construcotr
    private SwingCopter() {
        swingLeft = new Image("game/res/img/swingcopter_left.png");
        swingRight = new Image("game/res/img/swingcopter_right.png");
    }

    //Initializes the character
    public void initialize() {
        swingCopter = new ImageView(swingLeft);
        this.lifes = 0;
        this.score = 0;
        this.velocityX = 2;
        this.setTranslateX(StageManager.STAGE_WIDTH / 2);
        this.setTranslateY(StageManager.STAGE_HEIGHT - DISTANCE_SWING_WINDOW);
        this.getChildren().add(swingCopter);
    }

    //Inverses X-coordinate velocity
    public void inverseVelocityX() {
        this.velocityX = this.velocityX * (-1);
        this.setRotate(this.getRotate() * (-1));
        if (swingCopter.getImage() == swingLeft) {
            swingCopter.setImage(swingRight);
        }
        else {
            swingCopter.setImage(swingLeft);
        }
    }

    //Moves the character
    public void move() {
        if (this.getRotate() == 0 ) {
            this.setRotate(10);
        }
        this.setTranslateX(this.getTranslateX() + velocityX);
        if (this.getTranslateX() <= 0 || this.getTranslateX() >= StageManager.STAGE_WIDTH - SWING_WIDTH) {
            _reset();
            this.lifes--;
            this._checkLifes();
        }
    }

    //Getters
    public int getLifes() {
        return this.lifes;
    }

    public int getScore() {
        return this.score;
    }

    //Adders
    public void addScore() {
        this.score++;
    }

    public void addLife() {
        this.lifes++;
    }

    //Removes life
    public void removeLife() {
        _reset();
        this.lifes--;
        _checkLifes();
    }

    //Checks if character is still alive
    private void _checkLifes() {
        if (this.lifes < 0) {
            _die();
        }
    }

    //Kills the character and notifies game of its death
    private void _die()  {
        _reset();
        this.velocityX = 0;
        SceneManager.getSceneManager().getGameScene().notify("death");
    }

    //Resets the character's position
    private void _reset() {
        this.setTranslateX(StageManager.STAGE_WIDTH / 2);
        this.setTranslateY(this.getTranslateY() - (SWING_HEIGHT * 2));
        this.score--;
    }

}
