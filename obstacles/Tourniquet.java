package game.obstacles;

import game.collectibles.Coin;
import game.collectibles.Life;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tourniquet extends Pane {
    private ObstacleLeft left;
    private ObstacleRight right;
    private List<Hammer> hammers;
    private Life life;
    private Coin coin;
    private Random rand;
    private int y;
    private int pivot;

    public Tourniquet() {
        rand = new Random();
        y = rand.nextInt(400) + 35;
        //this.setTranslateY(y);
        pivot = rand.nextInt(60) *(-1);
        left = new ObstacleLeft(pivot, y);
        right = new ObstacleRight(pivot + 120 + 160, y);
        hammers = new ArrayList<>();
        hammers.add(new Hammer(((int)left.getTranslateX()) + 120 - 30,  y+7));
        hammers.add(new Hammer(((int)right.getTranslateX()) - 3 , y+7));

        // May generate a heart
        int heartProbability = rand.nextInt(5);
        if (heartProbability == 2) {
            life = new Life(145, rand.nextInt(350) + 40);
            this.getChildren().add(life);
        }
        this.getChildren().addAll(left, right);
        this.getChildren().addAll(hammers);

        //Will generate a coin
        this.coin = Coin.createCoin(this.pivot + 120 + 80, y-5);
        this.getChildren().add(coin);

    }

    public Life getHeart() {
        return this.life;
    }

    public Coin getCoin() {
        return this.coin;
    }

    public void removeHeart() {
        this.getChildren().remove(this.life);
        this.life = null;
    }

    public void removeCoin() {
        this.getChildren().remove(this.coin);
        this.coin = null;
    }

    public Bounds getLeftObstacleBounds() {
        return this.left.getBoundsInParent();
    }

    public Bounds getRightObstacleBounds() {
        return this.right.getBoundsInParent();
    }

    public List<Bounds> getHammerBounds() {
        List<Bounds> hammersBounds = new ArrayList<>();
        for (Hammer hammer : this.hammers) {
            hammersBounds.add(hammer.getBoundsInParent());
        }
        return hammersBounds;
    }

}
