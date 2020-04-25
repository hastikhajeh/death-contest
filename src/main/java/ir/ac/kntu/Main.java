package ir.ac.kntu;

import ir.ac.kntu.gamelogic.Contest;
import ir.ac.kntu.gamelogic.RandomHelper;
import ir.ac.kntu.gamelogic.Soldier;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.out.print("enter the number of soldiers: ");
        int num = scanner.nextInt();
        generateTeams(num);
        Contest contest = new Contest(num,team1,team2);
        System.out.println(contest.toString());
        while (contest.team1HasAlive() && contest.team2HasAlive()) {
            Soldier[] soldiers = contest.fight();
            System.out.println(contest.toString(soldiers));
        }

    }

    static ArrayList<Soldier> team1 = new ArrayList<>();
    static ArrayList<Soldier> team2 = new ArrayList<>();


    public static void generateTeams(int num) {
        int n = 0;
        for (int i = 0; i < num; i++, n++) {
            team1.add(new Soldier(n));
        }
        for (int i = 0; i < num; i++, n++) {
            team2.add(new Soldier(n));
        }
    }
}
