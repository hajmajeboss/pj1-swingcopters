package game.obstacles;

import javafx.geometry.Bounds;

public interface Obstacle {
    void setX(double x);
    void setY(double x);
    double getX();
    double getY();
    Bounds getBounds();

}
