package game.obstacles;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObstacleRight extends Pane implements Obstacle {

    private ImageView obstacle;

    public ObstacleRight(int x, int y) {
        this.setX(x);
        this.setY(y);
        obstacle = new ImageView(new Image("game/res/img/obstacle_right.png"));
        this.getChildren().add(obstacle);
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
