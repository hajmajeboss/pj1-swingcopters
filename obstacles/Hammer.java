package game.obstacles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Hammer extends Pane {
    private ImageView hammer;

    public Hammer(int x, int y) {
        hammer = new ImageView(new Image("game/res/img/hammer.png"));
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.getChildren().add(hammer);
    }
}
