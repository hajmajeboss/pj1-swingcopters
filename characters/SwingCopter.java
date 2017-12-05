package game.characters;

import game.scenes.Game;
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
    private double velocityX;
    private double velocityY;
    private int lifes;
    private int score;

    private SwingCopter() {}

    // Public methods
    public void initialize() {
        swingCopter = new ImageView(new Image("game/res/img/swing_ok.png"));
        this.lifes = 2;
        this.score = 0;
        this.velocityX = 2;
        this.velocityY = 0.5;
        this.setTranslateX(140);
        this.setTranslateY(380);
        this.getChildren().add(swingCopter);
    }

    public void inverseVelocityX() {
        this.velocityX = this.velocityX * (-1);
    }

    public void move() {
        this.setTranslateX(this.getTranslateX() + velocityX);
        if (this.getTranslateY() <= 0) {
            this.setTranslateY(440);
        }
        this.setTranslateY(this.getTranslateY() - velocityY);
        if (this.getTranslateX() <= 0 || this.getTranslateX() >= 320) {
            this.reset();
            this.lifes--;
            Game.notify("life_change");
            this.checkLifes();
        }
    }

    public int getLifes() {
        return this.lifes;
    }

    public int getScore() {
        return this.score;
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
        swingCopter.setImage(new Image("game/res/img/swing_ko.png"));
        this.reset();
        this.velocityY = 0;
        this.velocityX = 0;
        Game.notify("death");
    }

}
