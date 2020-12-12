package simplecricketgame;

import java.util.Random;
import java.util.Scanner;

public class CricketGameController {

    public static Scanner scanner;
    public static Random rand;
    static String team1Name = "";
    static String team2Name = "";

    int tossTheCoin() {
        int toss = rand.nextInt(4);
        System.out.println();

        switch (toss) {
            case 0:
                System.out.println("------------ " + team1Name + " WON THE TOSS AND SELECTED TO BAT FIRST ------------");
                break;
            case 1:
                System.out.println("------------ " + team1Name + " WON THE TOSS AND SELECTED TO BALL FIRST ------------");
                break;
            case 2:
                System.out.println("------------ " + team2Name + " WON THE TOSS AND SELECTED TO BAT FIRST ------------");
                break;
            case 3:
                System.out.println("------------ " + team2Name + " WON THE TOSS AND SELECTED TO BALL FIRST ------------");
                break;
        }
        return toss;
    }

    void displayScoreCard(Team team) {
        System.out.println();
        System.out.println("-------------------------------------------------------------------------------");
        System.out.println("TEAM: " + team.getTeamName() + " -------------------- " + team.getTeamScore() + " / " + team.getWickets());
        for (int i = 0; i < 6; i++) {
            System.out.println("Player " + (i + 1) + "        " + team.getPlayer(i).getPlayerScore() + "         " + team.getPlayer(i).getWicketBy());
        }
        System.out.println("-------------------------------------------------------------------------------");
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);
        rand = new Random();

        System.out.println("============================== CRICKET GAME =======================================");

        //Naming the Teams
        while (team1Name.equals("")) {
            System.out.print("Enter Team 1 name: ");
            team1Name = scanner.nextLine().trim();
        }
        while (team2Name.equals("")) {
            System.out.print("Enter Team 2 name: ");
            team2Name = scanner.nextLine().trim();
        }

        Team team1 = new Team(team1Name);
        Team team2 = new Team(team2Name);
        CricketGameController controller = new CricketGameController();

        int tossResult = controller.tossTheCoin();

        //Decide the batting team and play the match
        if (tossResult == 0 | tossResult == 3) {
            team1.play();
            controller.displayScoreCard(team1);
            team2.play();
            controller.displayScoreCard(team2);
        } else {
            team2.play();
            controller.displayScoreCard(team2);
            team1.play();
            controller.displayScoreCard(team1);
        }

        //Display the result of the match
        if (team1.getTeamScore() > team2.getTeamScore()) {
            System.out.println("TEAM " + team1.getTeamName() + " WON THE MATCH !");
        } else if (team1.getTeamScore() == team2.getTeamScore()) {
            System.out.println("MATCH IS DRAWN !");
        } else {
            System.out.println("TEAM " + team2.getTeamName() + " WON THE MATCH !");
        }

        System.out.println();
        System.out.println("============================== END GAME =======================================");
    }
}
