package ir.ac.kntu.gamelogic;

import java.util.ArrayList;

public class Contest {
    int round;
    int num;
    ArrayList<Soldier> team1;
    ArrayList<Soldier> team2;

    public Contest(int num, ArrayList<Soldier> team1, ArrayList<Soldier> team2) {
        round = 0;
        this.num = num;
        this.team1 = team1;
        this.team2 = team2;
    }

    public boolean team1HasAlive() {
        for (Soldier soldier : team1) {
            if (soldier.isAlive()) {
                return true;
            }
        }
        return false;
    }
    public boolean team2HasAlive() {
        for (Soldier soldier : team2) {
            if (soldier.isAlive()) {
                return true;
            }
        }
        return false;
    }

    public String toString(Soldier[] soldiers) {
        String s = "";
        s += "--------- ROUND " + round +" ---------\n";
        s += "Team ONE\n";
        for (Soldier soldier : team1) {
            s += soldier.toString();
        }
        s += "\n";
        s += "Team TWO\n";
        for (Soldier soldier : team2) {
            s += soldier.toString();
        }
        s += "\n";
        if (round > 0) {
            s+= soldiers[0].toString() + "from team one\n";
            s+= soldiers[1].toString() + "from team two\n";
        }
        s += "----------------------------\n";
        return s;
    }

    public String toString() {
        String s = "";
        s += "--------- ROUND " + round +" ---------\n";
        s += "Team ONE\n";
        for (Soldier soldier : team1) {
            s += soldier.toString();
        }
        s += "\n";
        s += "Team TWO\n";
        for (Soldier soldier : team2) {
            s += soldier.toString();
        }
        s += "\n";
        s += "----------------------------\n";
        return s;
    }

    public Soldier[] fight() {
        round++;
        Soldier soldier1;
        do {
        soldier1 = team1.get(RandomHelper.nextInt(num));
        } while (!soldier1.isAlive());
        Soldier soldier2;
        do {
            soldier2 = team2.get(RandomHelper.nextInt(num));
        } while (!soldier2.isAlive());
        if (soldier1.rifle.didHit()) {
            soldier2.life -= soldier1.rifle.damage;
        }
        if (soldier2.isAlive() && soldier2.rifle.didHit()) {
            soldier1.life -= soldier2.rifle.damage;
        }
        Soldier[] soldiers = new Soldier[2];
        soldiers[0] = soldier1;
        soldiers[1] = soldier2;
        return soldiers;
    }
}
