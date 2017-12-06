package game.res.anim;

import game.world.Cloud;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.util.Duration;

public class CloudParallaxAnim extends Transition {

    private Cloud cloud;
    private double velocityX;

    public CloudParallaxAnim(Cloud cloud, double velocityX) {
     this.cloud = cloud;
     this.velocityX = velocityX;
     this.setCycleCount(Animation.INDEFINITE);
     this.setCycleDuration(Duration.millis(200));
     this.setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac) {

        cloud.setTranslateX(cloud.getTranslateX() + velocityX);
        if (cloud.getTranslateX() <= -100) {
            cloud.setTranslateX(360);
            cloud.init();
        }
        else if (cloud.getTranslateX() >= 360) {
            cloud.setTranslateX(-100);
            cloud.init();
        }
        cloud.setTranslateY(cloud.getTranslateY() + 1);
        if (cloud.getTranslateY() > 480) {
            cloud.setTranslateY(-20);
        }

    }
}
