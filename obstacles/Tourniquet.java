package game.obstacles;

import game.collectibles.Coin;
import game.collectibles.Life;
import javafx.geometry.Bounds;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tourniquet extends Pane {
    private static int yIndex  = 180;
    private Obstacle left;
    private Obstacle right;
    private List<Obstacle> hammers;
    private Life life;
    private Coin coin;
    private Random rand;
    private int y;
    private int pivot;

    public Tourniquet() {
        rand = new Random() ;
        y = yIndex;
        yIndex -= 240;
        pivot = rand.nextInt(60) *(-1);
        left = new ObstacleLeft(pivot, y);
        right = new ObstacleRight(pivot + 120 + 180, y);
        hammers = new ArrayList<>();
        hammers.add(new Hammer(((int)left.getX()) + 120 - 38,  y+25));
        hammers.add(new Hammer(((int)right.getX()) -12 , y+25));

        // May generate a heart
        int heartProbability = rand.nextInt(5);
        if (heartProbability == 2) {
            life = new Life(145, rand.nextInt(350) + 40);
            this.getChildren().add(life);
        }
        this.getChildren().addAll((Pane)left, (Pane)right);
        this.getChildren().addAll((Pane)hammers.get(0), (Pane)hammers.get(1));

        //Will generate a coin
        this.coin = Coin.createCoin(this.pivot + 120 + 80, y-5);
        this.getChildren().add(coin);

    }

    public void moveDown() {
        if (left.getY() < 480) {
            left.setY(left.getY() + 1);
            right.setY(right.getY() + 1);
            if (coin != null) {
                coin.setTranslateY(coin.getTranslateY() + 1);
            }
            if (life != null) {
                life.setTranslateY(life.getTranslateY() + 1);
            }
            for (Obstacle hammer : hammers) {
                hammer.setY(hammer.getY() + 1);
            }
        }
        else {
            left.setY(-10);
            right.setY(-10);
            for (Obstacle hammer : hammers) {
                hammer.setY(8);
            }
            coin = Coin.createCoin(this.pivot + 120 + 80, (int)left.getY() - 5);
            this.getChildren().add(coin);
        }
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
        return this.left.getBounds();
    }

    public Bounds getRightObstacleBounds() {
        return this.right.getBounds();
    }

    public List<Bounds> getHammerBounds() {
        List<Bounds> hammersBounds = new ArrayList<>();
        for (Obstacle hammer : this.hammers) {
            hammersBounds.add(hammer.getBounds());
        }
        return hammersBounds;
    }

    public static void resetYIndex() {
        Tourniquet.yIndex = 180;
    }

}


