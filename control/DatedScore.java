package game.control;

public class DatedScore {

    //Properties
    private int score;
    private String date;

    //Constructor
    public DatedScore(int score, String date) {
        this.score = score;
        this.date = date;
    }

    //Getters
    public int getScore() {
        return this.score;
    }

    public String getDate() {
        return this.date;
    }
}
