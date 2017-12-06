package game.scenes;

import game.characters.SwingCopter;
import game.obstacles.Tourniquet;
import game.world.Cloud;
import javafx.animation.AnimationTimer;
import javafx.geometry.Bounds;

import java.util.List;

public class GameLoop extends AnimationTimer {
    private static GameLoop gameLoop = new GameLoop();
    public static GameLoop getGameLoop() {return GameLoop.gameLoop;}
    private GameLoop() {}

    SwingCopter swingCopter;
    List<Tourniquet> tourniquets;


    @Override
    public void handle(long now) {
        //Update score/life counters
        Game.getGameScene().update();

        //Collision Handling
        for (Tourniquet tourniquet : tourniquets) {

            if (    tourniquet.getCoin() != null &&
                    tourniquet.getCoin().getBoundsInParent().intersects(swingCopter.getBoundsInParent())) {
                tourniquet.removeCoin();
                swingCopter.addScore();
            }

            if (    tourniquet.getHeart() != null &&
                    tourniquet.getHeart().getBoundsInParent().intersects(swingCopter.getBoundsInParent())) {
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
        swingCopter.move();

    }

    public GameLoop initialize(List<Tourniquet> tourniquets) {
        this.swingCopter = SwingCopter.getSwingCopter();
        this.tourniquets = tourniquets;
        return this;
    }
}

