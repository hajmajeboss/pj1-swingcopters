package game.obstacles;

import game.res.anim.HammerRotateAnim;
import javafx.animation.Animation;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Hammer extends Pane implements Obstacle {

    private ImageView hammer;
    private Animation hammerRotate;

    public Hammer(int x, int y) {
        this.setX(x);
        this.setY(y);
        hammer = new ImageView(new Image("game/res/img/hammer.png"));
        this.getChildren().add(hammer);

        //Plays hammer rotate animation
        hammerRotate  = new HammerRotateAnim(this);
        hammerRotate.play();
    }

    //Setters
    @Override
    public void setX (double x) {
        this.setTranslateX(x);
    }

    @Override
    public void setY (double y) {
        this.setTranslateY(y);
    }

    //Getters
    @Override
    public double getY() {
        return this.getTranslateY();
    }

    @Override
    public double getX() {
        return this.getTranslateX();
    }

    @Override
    public Bounds getBounds() {
        return this.getBoundsInParent();
    }
}
