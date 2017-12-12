package game.characters;

import game.control.DatedScore;
import game.control.ScoreManager;
import game.control.SoundManager;
import game.scenes.SceneManager;
import game.stages.StageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;

import javax.print.attribute.standard.Media;

//TODO helicopter movement
//TODO death when has extra life - restart
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

    //Sounds
    private MediaPlayer lifeLost;
    private MediaPlayer fail;
    private MediaPlayer success;

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
        lifeLost = SoundManager.getSoundManager().getLifeLost();
        fail = SoundManager.getSoundManager().getFail();
        success = SoundManager.getSoundManager().getSuccess();
    }

    //Initializes the character
    public void initialize(int score, int lifes) {
        swingCopter = new ImageView(swingLeft);
        this.lifes = lifes;
        this.score = score;
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
    public void addScore() { this.score++; }

    public void addLife() {
        this.lifes++;
    }

    //Removes life
    public void removeLife() {
        this.lifes--;
        _checkLifes();

    }

    //Checks if character is still alive
    private void _checkLifes() {
        if (this.lifes < 0) {
            _die();
        }
        else {
            _loseLife();
        }
    }

    private void _loseLife() {
        lifeLost.stop();
        lifeLost.play();
        ScoreManager.getScoreManager().saveScore(this.score, this.lifes);
        _reset();
        this.velocityX = 0;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SceneManager.getSceneManager().getGameScene().notify("life_lost");
    }

    //Kills the character and notifies game of its death
    private void _die()  {
        ScoreManager.getScoreManager().saveScore(this.score, 0);
        DatedScore highscore = ScoreManager.getScoreManager().getHighScore();
        if (this.score > highscore.getScore()) {
            success.stop();
            success.play();
            ScoreManager.getScoreManager().saveHighScore(this.score);
        }
        else {
            fail.stop();
            fail.play();
        }
        _reset();
        this.velocityX = 0;
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        SceneManager.getSceneManager().getGameScene().notify("death");
    }

    //Resets the character's position out of scene
    private void _reset() {
        this.setTranslateY(-1000);
    }

}
