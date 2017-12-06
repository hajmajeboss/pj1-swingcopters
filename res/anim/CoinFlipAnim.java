package game.res.anim;

import game.collectibles.Coin;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.Transition;
import javafx.scene.image.Image;
import javafx.util.Duration;

public class CoinFlipAnim extends Transition {

    Coin coin;
    Image[] coinImgs = {new Image("game/res/img/coin.png"),
                        new Image("game/res/img/coin1.png"),
                        new Image("game/res/img/coin2.png"),
                        new Image("game/res/img/coin3.png"),
                        new Image("game/res/img/coin4.png"),
                        new Image("game/res/img/coin5.png")
    };

    public CoinFlipAnim(Coin coin) {
        this.coin = coin;
        setCycleCount(Animation.INDEFINITE);
        setCycleDuration(Duration.millis(500));
        setInterpolator(Interpolator.LINEAR);
    }

    @Override
    protected void interpolate(double frac) {
        if (frac < 0.166666666) coin.setImage(coinImgs[0]);
        if (frac >= 0.166666666 && frac < 0.33333333) coin.setImage(coinImgs[1]);
        if (frac >= 0.33333333 && frac < 0.499999999) coin.setImage(coinImgs[2]);
        if (frac >=  0.499999999 && frac < 0.666666666) coin.setImage(coinImgs[3]);
        if (frac >=  0.666666666 && frac < 0.833333333) coin.setImage(coinImgs[4]);
        if (frac >=  0.833333333 && frac < 1.0) coin.setImage(coinImgs[5]);
        if (frac == 1.0) coin.setImage(coinImgs[0]);
    }
}
