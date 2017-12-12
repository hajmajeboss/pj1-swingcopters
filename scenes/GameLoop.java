package game.scenes;

import game.characters.SwingCopter;
import game.collectibles.Coin;
import game.obstacles.Tourniquet;
import game.world.City;
import game.world.Cloud;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;

import java.util.List;

public class GameLoop extends AnimationTimer {

    //Game objects
    SwingCopter swingCopter;
    City city;
    List<Tourniquet> tourniquets;
    List<Cloud> clouds;

    public GameLoop() {}

    //Handles the game loop
    @Override
    public void handle(long now) {

        //Updates score/life counters
        SceneManager.getSceneManager().getGameScene().update();

        //Moves city
        city.move();

        //Moves Swing Copter
        swingCopter.move();

        for (Tourniquet tourniquet : tourniquets) {

            //Moves tourniquet
            tourniquet.moveDown();

            //Checks if coin has been collected
            if (tourniquet.getCoin() != null && tourniquet.getCoin().getBounds().intersects(swingCopter.getBoundsInParent())) {
                tourniquet.getCoin().playSound();
                tourniquet.removeCoin();
                swingCopter.addScore();
            }

            //Checks if heart has been collected
            if (tourniquet.getHeart() != null && tourniquet.getHeart().getBounds().intersects(swingCopter.getBoundsInParent())) {
                tourniquet.getHeart().playSound();
                tourniquet.removeHeart();
                swingCopter.addLife();
            }

            //Checks collision with obstacle
            for (Bounds obstacleBounds : tourniquet.getObstaclesBounds()) {
                if (obstacleBounds.intersects(swingCopter.getBoundsInParent())) {
                    swingCopter.removeLife();
                }
            }
        }
    }

    //Initializes the loop
    public GameLoop initialize(List<Tourniquet> tourniquets, List<Cloud> clouds) {
        this.swingCopter = SwingCopter.getSwingCopter();
        this.city = City.getCity();
        this.tourniquets = tourniquets;
        this.clouds = clouds;
        return this;
    }
}

