package game.obstacles;

import game.collectibles.Life;
import javafx.scene.layout.Pane;

import java.util.Random;

public class Tourniquet extends Pane {
    private Obstacle left;
    private Obstacle right;
    private Life life;
    private Random rand;
    private int y;

    public Tourniquet() {
        rand = new Random();
        y = rand.nextInt(420);
        left = new ObstacleLeft(rand.nextInt(150), y);
        right = new ObstacleRight(rand.nextInt(150) + 150, y);

        // May generate a heart
        int heartProbability = rand.nextInt(10);
        if (heartProbability == 5) {
            life = new Life(10, y);
        }
    }

}
