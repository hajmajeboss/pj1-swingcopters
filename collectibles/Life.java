package game.collectibles;

import game.control.SoundManager;
import javafx.geometry.Bounds;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.media.MediaPlayer;

import javax.print.attribute.standard.Media;

public class Life extends Pane implements Collectible {

    private ImageView life;
    private MediaPlayer heartCollect;

    public Life(int x, int y) {
        this.setX(x);
        this.setY(y);
        life = new ImageView(new Image("game/res/img/heart.png"));
        heartCollect = SoundManager.getSoundManager().getHeartCollect();
        this.getChildren().add(life);
    }

    //Setters
    @Override
    public void setX (double x) {
        this.setTranslateX(x);
    }

    @Override
    public void setY (double y) {
        this.setTranslateY(y);
    }

    //Getters
    @Override
    public double getY() {
        return this.getTranslateY();
    }

    @Override
    public double getX() {
        return this.getTranslateX();
    }

    @Override
    public Bounds getBounds() {
        return this.getBoundsInParent();
    }

    @Override
    public void playSound() {
        heartCollect.stop();
        heartCollect.play();
    }

}
