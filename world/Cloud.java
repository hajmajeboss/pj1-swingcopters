package game.world;

import game.res.anim.CloudParallaxAnim;
import game.scenes.SceneManager;
import game.stages.StageManager;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Cloud extends Pane {

    //Constants
    public static final int DISTANCE_CLOUD_WINDOW = 100;

    //Properties
    private ImageView cloud;
    private double velocityX;
    private Random rand;
    private Animation cloudAnim;

    public Cloud() {
        rand = new Random();
        this.init();
        cloudAnim = new CloudParallaxAnim(this, this.velocityX);
        this.cloud = new ImageView(new Image("game/res/img/cloud.png"));
        this.setTranslateX(-30);
        this.getChildren().add(this.cloud);
        cloudAnim.play();
    }

    public void init() {
        this.setTranslateY(rand.nextInt(StageManager.STAGE_HEIGHT - DISTANCE_CLOUD_WINDOW));
        this.velocityX = rand.nextInt(4) -2;
        if (this.velocityX == 0) {
            this.velocityX = 1;
        }
    }
}
