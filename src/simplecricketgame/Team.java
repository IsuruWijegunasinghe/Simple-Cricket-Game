package simplecricketgame;

import java.util.Random;
import java.util.Scanner;

public class Team {

    Scanner scanner = new Scanner(System.in);
    Random rand = new Random();
    private String teamName;
    private int teamScore;
    private int wickets;
    private Player[] players;

    //Team Constructor
    public Team(String teamName) {
        this.teamName = teamName;
        this.teamScore = 0;
        this.wickets = 0;
        players = new Player[6];
        for (int p = 0; p < 6; p++) {
            players[p] = new Player("Player " + (p + 1));
        }
    }

    public String getTeamName() {
        return teamName;
    }

    public int getTeamScore() {
        return teamScore;
    }

    public void addRuns(int runs) {
        this.teamScore += runs;
    }

    public int getWickets() {
        return wickets;
    }

    public Player getPlayer(int position) {
        return players[position];
    }

    void play() {
        int currentPlayerPosition = 0;
        Player currentPlayer = players[currentPlayerPosition];
        int currentBowler = rand.nextInt(6) + 1;

        for (int over = 1; over < 6; over++) {
            for (int ball = 1; ball < 4; ball++) {
                System.out.println();
                System.out.println("Team: " + teamName + "  Over: " + over + " Ball: " + ball + "    (Press p to hit the ball...)");

                if (scanner.next().equals("p")) {
                    int result = rand.nextInt(8);
                    if (result < 6) {
                        if (result == 5) {
                            result += 1;
                        }
                        currentPlayer.scoreRuns(result);
                        this.addRuns(result);
                    } else {
                        currentPlayer.getOut();
                        if (result == 6) {
                            currentPlayer.setWicketBy("b: Player " + currentBowler);
                        } else {
                            currentPlayer.setWicketBy("b: Player " + currentBowler + " / c: Player " + rand.nextInt(6));
                        }
                        this.wickets += 1;
                        currentPlayerPosition += 1;
                        currentPlayer = players[currentPlayerPosition];
                    }
                } else {
                    System.out.println("Missed the ball !");
                }
                System.out.println(" ---> " + this.getTeamScore() + " / " + this.getWickets());
                //Finish the match after 6 wickets
                if (wickets == 6) {
                    return;
                }
            }
            //Change the bowler after an over
            currentBowler = rand.nextInt(6) + 1;
        }
    }
}
