package game.obstacles;

import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class ObstacleLeft extends Pane {
    private ImageView obstacle;

    public ObstacleLeft(int x, int y) {
        obstacle = new ImageView(new Image("game/res/img/obstacle_left.png"));
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.getChildren().add(obstacle);
    }
}
