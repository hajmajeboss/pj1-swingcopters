package game.world;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class City extends Pane{
    private ImageView city;
    private final int height = 120;
    private static  City cityInstance = new City();
    public static City getCity() {return cityInstance;}

    private City() {
        city = new ImageView(new Image("game/res/img/background_city.png"));
        this.setTranslateY(480 - height);
        this.getChildren().add(city);
    }

    public void move() {
        this.setTranslateY(this.getTranslateY() + 1);
    }

    public void resetCity() {
        this.setTranslateY(480-height);
    }

}
