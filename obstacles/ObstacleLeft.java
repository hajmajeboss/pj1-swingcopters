package game.obstacles;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObstacleLeft extends Pane implements Obstacle{
    private ImageView obstacle;

    public ObstacleLeft(int x, int y) {
        obstacle = new ImageView(new Image("game/res/img/obstacle_left.png"));
        this.setX(x);
        this.setY(y);
        this.getChildren().add(obstacle);
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
