package game.control;

import java.io.*;
import java.time.LocalDateTime;

public class ScoreManager {

    //Singleton pattern - instance of itself
    private static ScoreManager scoreManager = new ScoreManager();
    public static ScoreManager getScoreManager() {return scoreManager;};

    //Constants
    private String WORKSPACE_PATH = System.getProperty("user.dir");

    //Properties
    private int score;
    private int lifes;
    private boolean newHighscore;

    //File input/output
    private File lastScoreFile;
    private File highScoreFile;
    private PrintWriter dateWriter;
    private BufferedReader scoreIn;
    private BufferedReader highScoreIn;
    private FileWriter scoreOut;
    private FileWriter highScoreOut;

    //Singleton - private constructor
    private ScoreManager() {
        newHighscore = false;
        try {
            lastScoreFile = new File (WORKSPACE_PATH , "last_score.sc");
            highScoreFile = new File(WORKSPACE_PATH, "highscore.sc");
            if (!lastScoreFile.exists()) {
                lastScoreFile.createNewFile();
            }
            if (!highScoreFile.exists()) {
                highScoreFile.createNewFile();
            }
            scoreIn = new BufferedReader(new FileReader(lastScoreFile));
            highScoreIn =  new BufferedReader(new FileReader(highScoreFile));
        } catch (FileNotFoundException e) {}
        catch (IOException e) {}
    }

    //Reads score from file
    public LastScore getScore() {
        try {
            this.score = scoreIn.read();
            if (this.score != -1) {
                this.lifes = scoreIn.read();
                scoreIn.close();
                scoreIn = new BufferedReader(new FileReader(lastScoreFile));
                return new LastScore(this.score, this.lifes);
            }
            else {
                return new LastScore(0,0);
            }
        } catch (Exception e) {
            return new LastScore(0,0);
        }
    }

    //Reads highscore and date it was set from file
    public DatedScore getHighScore() {
        try {
            highScoreIn.mark(11);
            int highScoreIter= highScoreIn.read();
            int highScore;
            StringBuilder date = new StringBuilder();
            if  (highScoreIter == -1) {
                return new DatedScore(0, "never");
            }
            else {
                highScore = highScoreIter;
            }
            highScoreIter= highScoreIn.read();
            while (highScoreIter != -1) {
                date.append(Character.toChars(highScoreIter));
                highScoreIter = highScoreIn.read();
            }
            highScoreIn.close();
            highScoreIn = new BufferedReader(new FileReader(highScoreFile));
            return new DatedScore(highScore, date.toString());

        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

    }

    //Saves score into file
    public void saveScore(int score, int lifes) {
        try {
            scoreOut = new FileWriter(lastScoreFile, false);
            this.scoreOut.write(score);
            this.scoreOut.write(lifes);
        } catch (IOException e) {
            System.out.println("save s");
        }
        finally {
            try {
                this.scoreOut.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Saves highscore into file
    public void saveHighScore(int score) {
        newHighscore = true;
        try {
            highScoreOut = new FileWriter(highScoreFile, false);
            dateWriter = new PrintWriter(highScoreFile);

            this.highScoreOut.write(score);
            LocalDateTime date = LocalDateTime.now();
            this.dateWriter.write(" " + date.getDayOfMonth() + "." + date.getMonthValue() + "." + date.getYear());


        } catch (IOException e) {
            e.printStackTrace();
        }
        finally {
            try {
                dateWriter.flush();
                this.highScoreOut.flush();

            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    //Tells whether new highscore was set during gameplay
    public boolean isNewHighscore() {
        return this.newHighscore;
    }

    //Setters
    public void setNewHighscore(boolean bool) {
        newHighscore = bool;
    }

}
