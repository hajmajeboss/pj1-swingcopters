package game.scenes;

import game.characters.SwingCopter;
import game.obstacles.Tourniquet;
import game.world.City;
import game.world.Cloud;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;

import java.util.List;

public class GameLoop extends AnimationTimer {

    public GameLoop() {}

    //Game objects
    SwingCopter swingCopter;
    List<Tourniquet> tourniquets;
    List<Cloud> clouds;

    //Game loop
    @Override
    public void handle(long now) {
        //Update score/life counters
        SceneManager.getSceneManager().getGameScene().update();

        //Moves city
        City.getCity().move();

        //Moves Swing Copter
        swingCopter.move();


        //Collision Handling
        for (Tourniquet tourniquet : tourniquets) {
            tourniquet.moveDown();

            if (    tourniquet.getCoin() != null &&
                    tourniquet.getCoin().getBounds().intersects(swingCopter.getBoundsInParent())) {
                tourniquet.removeCoin();
                swingCopter.addScore();
            }

            if (    tourniquet.getHeart() != null &&
                    tourniquet.getHeart().getBounds().intersects(swingCopter.getBoundsInParent())) {
                tourniquet.removeHeart();
                swingCopter.addLife();
            }

            if (tourniquet.getLeftObstacleBounds().intersects(swingCopter.getBoundsInParent()) ||
                    tourniquet.getRightObstacleBounds().intersects(swingCopter.getBoundsInParent())) {
                swingCopter.removeLife();
            }

            for (Bounds hammerBounds : tourniquet.getHammerBounds()) {
                if (hammerBounds.intersects(swingCopter.getBoundsInParent())) {
                    swingCopter.removeLife();
                }
            }
        }
    }

    //Initializes the loop
    //@returns itself - chaining
    public GameLoop initialize(List<Tourniquet> tourniquets, List<Cloud> clouds) {
        this.swingCopter = SwingCopter.getSwingCopter();
        this.tourniquets = tourniquets;
        this.clouds = clouds;
        return this;
    }
}

