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

