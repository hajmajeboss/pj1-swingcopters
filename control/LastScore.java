package game.control;

public class LastScore {
    private int score;
    private int lifes;

    public LastScore(int score, int lifes) {
        this.score = score;
        this.lifes = lifes;
    }

    public int getLifes() {
        return lifes;
    }

    public int getScore() {
        return score;
    }
}
