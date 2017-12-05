package game.world;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Cloud extends Pane {
    private ImageView cloud;
    private double velocityX;
    private Random rand;

    public Cloud() {
        rand = new Random();
        this.cloud = new ImageView(new Image("game/res/img/cloud.png"));
        this.init();
        this.setTranslateX(-30);
        this.getChildren().add(this.cloud);
    }

    public void move() {
        this.setTranslateX(this.getTranslateX() + velocityX);
        if (this.getTranslateX() <= -100) {
            this.setTranslateX(360);
            this.init();
        }
        else if (this.getTranslateX() >= 360) {
            this.setTranslateX(-100);
            this.init();
        }
    }

    private void init() {
        this.setTranslateY(rand.nextInt(400));
        this.velocityX = rand.nextInt(4) -2;
        if (this.velocityX == 0) {
            this.velocityX = 1;
        }
    }
}
