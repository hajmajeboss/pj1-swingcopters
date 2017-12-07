package game.world;

import game.stages.StageManager;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;


public class City extends Pane{

    //Singleton pattern - creates instance of itself
    private static  City cityInstance = new City();
    public static City getCity() {return cityInstance;}

    //Constants
    private final int CITY_HEIGHT = 120;

    //Images
    private ImageView city;

    //Singleton pattern - private constructor
    private City() {
        city = new ImageView(new Image("game/res/img/background_city.png"));
        this.setTranslateY(StageManager.STAGE_HEIGHT - CITY_HEIGHT);
        this.getChildren().add(city);
    }

    public void move() {
        this.setTranslateY(this.getTranslateY() + 1);
    }

    public void resetCity() {
        this.setTranslateY(StageManager.STAGE_HEIGHT - CITY_HEIGHT);
    }

}
