package game.res.anim;

import game.collectibles.Coin;
import game.obstacles.Hammer;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;


public class HammerRotateAnim extends Transition {
    Hammer hammer;
    public HammerRotateAnim(Hammer hammer) {
        this.hammer = hammer;
        setCycleCount(Animation.INDEFINITE);
        setCycleDuration(Duration.millis(1000));
        setInterpolator(Interpolator.LINEAR);

    }
    @Override
    protected void interpolate(double frac) {
        if (frac < (1/7)) {
            hammer.setRotate(5);

        }

        if (frac >= (1.0/7) && frac < (2.0/7)) {
            hammer.setRotate(10);

        }

        if (frac >= (2.0/7) && frac < (3.0/7)) {
            hammer.setRotate(5);

        }

        if (frac >= (3.0/7) && frac < (4.0/7)) {
            hammer.setRotate(0);

        }

        if (frac >= (4.0/7) && frac < (5.0/7)) {

            hammer.setRotate(-5);
        }

        if (frac >= (5.0/7) && frac < (6.0/7)) {

            hammer.setRotate(-10);
        }

        if (frac >=  (6.0/7) && frac < 1.0) {

            hammer.setRotate(-5);
        }

        if (frac == 1.0) {

            hammer.setRotate(0);
        }

    }
}
