package game.obstacles;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObstacleLeft extends Pane implements Obstacle{
    private ImageView obstacle;

    public ObstacleLeft(int x, int y) {
        obstacle = new ImageView(new Image("game/res/img/obstacle_left"));
        this.setTranslateX(x);
        this.setTranslateY(x);
        this.getChildren().add(obstacle);
    }

    public Bounds getBounds() {
        return this.getBoundsInParent();
    }
}
