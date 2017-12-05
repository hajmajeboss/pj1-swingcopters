package game.obstacles;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObstacleRight extends Pane implements Obstacle {
    private ImageView obstacle;

    public ObstacleRight(int x, int y) {
        obstacle = new ImageView(new Image("game/res/img/obstacle_right"));
        this.setTranslateX(x);
        this.setTranslateY(x);
        this.getChildren().add(obstacle);
    }

    public Bounds getBounds() {
        return this.getBoundsInParent();
    }
}