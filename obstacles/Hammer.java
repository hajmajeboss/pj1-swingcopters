package game.obstacles;

import game.res.anim.HammerRotateAnim;
import javafx.animation.Animation;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Hammer extends Pane implements Obstacle {
    private ImageView hammer;

    public Hammer(int x, int y) {
        hammer = new ImageView(new Image("game/res/img/hammer.png"));
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.getChildren().add(hammer);
        Animation hammerRotate = new HammerRotateAnim(this);
        hammerRotate.play();
    }

    public void setX (double x) {
        this.setTranslateX(x);
    }

    public void setY (double y) {
        this.setTranslateY(y);
    }

    public double getY() {
        return this.getTranslateY();
    }

    public double getX() {
        return this.getTranslateX();
    }

    public Bounds getBounds() {
        return this.getBoundsInParent();
    }
}
