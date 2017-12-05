package game.collectibles;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Life extends Pane {
    private ImageView life;

    public Life(int x, int y) {
        life = new ImageView(new Image("game/res/img/heart.png"));
        this.setTranslateX(x);
        this.setTranslateY(y);
        this.getChildren().add(life);
    }

}
