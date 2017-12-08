package game.collectibles;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Life extends Pane implements Collectible {

    private ImageView life;

    public Life(int x, int y) {
        this.setX(x);
        this.setY(y);
        life = new ImageView(new Image("game/res/img/heart.png"));
        this.getChildren().add(life);
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
