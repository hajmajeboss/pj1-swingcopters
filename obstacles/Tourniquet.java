package game.obstacles;

import game.collectibles.Coin;
import game.collectibles.Collectible;
import game.collectibles.Life;
import game.stages.StageManager;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.layout.Pane;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Tourniquet extends Pane {
    
    //Constants
    private static final int DISTANCE_BETWEEN_OBSTACLES = 180;
    private static final int OBSTACLE_WIDTH = 120;
    private static final int DISTANCE_BETWEEN_TOURNIQUETS = 240;
    private static final int DISTANCE_OBSTACLE_HAMMER_Y = 25;
    private static final int DISTANCE_OBSTACLE_LEFT_HAMMER_X = 38;
    private static final int DISTANCE_OBSTACLE_RIGHT_HAMMER_X = 12;

    //Index to generate tourniquets
    private static int yIndex  = DISTANCE_BETWEEN_TOURNIQUETS;

    //Obstacles
    private Obstacle left;
    private Obstacle right;
    private List<Obstacle> hammers;

    //Collectibles
    private Collectible life;
    private Collectible coin;

    //Generating tourniquets variables
    private Random rand;
    private int y;
    private int pivot;

    //Will reset index to generate tourniquets
    public static void resetYIndex() {
        Tourniquet.yIndex = DISTANCE_BETWEEN_TOURNIQUETS;
    }

    //Constructor
    public Tourniquet() {

        //Will set the pivot
        rand = new Random() ;
        pivot = rand.nextInt(60) *(-1);

        //Will set the Y coordinate of the tourniquet
        y = yIndex;
        yIndex -= DISTANCE_BETWEEN_TOURNIQUETS;

        //May generate a heart and add it to the layout
        _generateHeart(y);

        //Will generate a coin and add it to the layout
        _generateCoin(y);

        //Will generate obstacles
        left = new ObstacleLeft(pivot, y);
        right = new ObstacleRight(pivot + OBSTACLE_WIDTH + DISTANCE_BETWEEN_OBSTACLES, y);
        hammers = new ArrayList<>();
        hammers.add(new Hammer(((int)left.getX()) + OBSTACLE_WIDTH - DISTANCE_OBSTACLE_LEFT_HAMMER_X,  y+ DISTANCE_OBSTACLE_HAMMER_Y));
        hammers.add(new Hammer(((int)right.getX()) - DISTANCE_OBSTACLE_RIGHT_HAMMER_X, y+DISTANCE_OBSTACLE_HAMMER_Y));

        //Will add obstacles to the layout
        this.getChildren().addAll((Node)left, (Node)right);
        this.getChildren().addAll((Node)hammers.get(0), (Node)hammers.get(1));

    }

    //Will move the tourniquet down to create dynamic parallax effect
    public void moveDown() {

        //Checks if tourniquet is in visible part of stage
        if (left.getY() < StageManager.STAGE_HEIGHT) {
            left.setY(left.getY() + 1);
            right.setY(right.getY() + 1);
            if (coin != null) {
                coin.setY(coin.getY() + 1);
            }
            if (life != null) {
                life.setY(life.getY() + 1);
            }
            for (Obstacle hammer : hammers) {
                hammer.setY(hammer.getY() + 1);
            }
        }
        //Sets the tourniquet's objects position out of the visible part of stage if the upper condition is not met
        else {
            left.setY(-25);
            right.setY(-25);
            for (Obstacle hammer : hammers) {
                hammer.setY(left.getY() + DISTANCE_OBSTACLE_HAMMER_Y);
            }
            _generateCoin((int)left.getY());
            _generateHeart((int)left.getY());
        }
    }

    //Generators
    private void _generateHeart(int y) {
        int heartProbability = rand.nextInt(10);
        if (heartProbability == 1) {
            life = new Life(this.pivot + OBSTACLE_WIDTH + (DISTANCE_BETWEEN_OBSTACLES / 2), y);
            this.getChildren().add((Node)life);
        }
    }

    private void _generateCoin(int y) {
        this.coin = new Coin(this.pivot + OBSTACLE_WIDTH + (DISTANCE_BETWEEN_OBSTACLES / 2), y);
        this.getChildren().add((Node)coin);

    }

    //Removers
    public void removeHeart() {
        this.getChildren().remove(this.life);
        this.life = null;
    }

    public void removeCoin() {
        this.getChildren().remove(this.coin);
        this.coin = null;
    }

    //Getters
    public Collectible getHeart() {
        return this.life;
    }

    public Collectible getCoin() {
        return this.coin;
    }

    public List<Bounds> getObstaclesBounds() {
        List<Bounds> obstacleBounds = new ArrayList<>();
        obstacleBounds.add(left.getBounds());
        obstacleBounds.add(right.getBounds());
        for (Obstacle hammer : this.hammers) {
            obstacleBounds.add(hammer.getBounds());
        }
        return obstacleBounds;
    }
}


