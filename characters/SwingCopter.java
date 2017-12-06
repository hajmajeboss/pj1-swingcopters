package game.characters;

import game.scenes.SceneManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class SwingCopter extends Pane {

    private static SwingCopter ourInstance = new SwingCopter();
    public static SwingCopter getSwingCopter() {
        return ourInstance;
    }

    //Properties
    private ImageView swingCopter;
    private Image swingLeft;
    private Image swingRight;
    private double velocityX;
    private int lifes;
    private int score;

    private SwingCopter() {
        swingLeft = new Image("game/res/img/swingcopter_left.png");
        swingRight = new Image("game/res/img/swingcopter_right.png");
    }

    // Public methods
    public void initialize() {
        swingCopter = new ImageView(swingLeft);
        this.lifes = 0;
        this.score = 0;
        this.velocityX = 2;
        this.setTranslateX(140);
        this.setTranslateY(380);
        this.getChildren().add(swingCopter);
    }

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

    public void move() {
        if (this.getRotate() == 0 ) {
            this.setRotate(10);
        }
        this.setTranslateX(this.getTranslateX() + velocityX);
        if (this.getTranslateY() <= 0) {
            this.setTranslateY(440);
        }
        if (this.getTranslateX() <= 0 || this.getTranslateX() >= 320) {
            this.reset();
            this.lifes--;
            this.checkLifes();
        }
    }

    public int getLifes() {
        return this.lifes;
    }

    public int getScore() {
        return this.score;
    }

    public void addScore() {
        this.score++;
    }

    public void addLife() {
        this.lifes++;
    }

    public void removeLife() {
        this.reset();
        this.lifes--;
        this.checkLifes();
    }

    //Private methods
    private void reset() {
        this.setTranslateX(140);
    }

    private void checkLifes() {
        if (this.lifes < 0) {
            this.die();
        }
    }

    private void die()  {
        this.reset();
        this.velocityX = 0;
        SceneManager.getSceneManager().getGameScene().notify("death");
    }

}
