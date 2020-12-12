package simplecricketgame;

public class Player {

    private String playerName;
    private int playerScore;
    private String wicketBy;

    //Player Constructor
    public Player(String playerName) {
        this.playerName = playerName;
        this.playerScore = 0;
        this.wicketBy = "Not Out";
    }

    public String getPlayerName() {
        return playerName;
    }

    public int getPlayerScore() {
        return playerScore;
    }

    public void setPlayerScore(int playerScore) {
        this.playerScore = playerScore;
    }

    public String getWicketBy() {
        return wicketBy;
    }

    public void setWicketBy(String wicketBy) {
        this.wicketBy = wicketBy;
    }

    void scoreRuns(int runs) {
        System.out.print(runs + " runs");
        this.playerScore += runs;
    }

    void getOut() {
        System.out.print("Out");
    }
}
