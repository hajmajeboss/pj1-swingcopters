package game.collectibles;

import javafx.geometry.Bounds;

public interface Collectible {
    void setX(double x);
    void setY(double x);
    double getX();
    double getY();
    Bounds getBounds();
    void playSound();
}
