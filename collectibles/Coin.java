package game.collectibles;

import game.res.anim.CoinFlipAnim;
import javafx.animation.Animation;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;

public class Coin extends Pane {
    ImageView coin;

    public Coin() {
        coin = new ImageView(new Image("game/res/img/coin.png"));
        this.getChildren().add(coin);
        Animation coinFlip = new CoinFlipAnim(this);
        coinFlip.play();
    }

    public void setImage(Image image) {
        coin.setImage(image);
    }

    public static Coin createCoin(int x, int y) {
        Coin coin = new Coin();
        coin.setTranslateY(y);
        coin.setTranslateX(x);
        return coin;
    }
}