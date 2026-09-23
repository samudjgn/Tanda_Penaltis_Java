package TandaPenaltis;

public class PenaltyShotooutRegister {

    private Player kicker;
    private Player goalkeeper;
    private int goals;
    private int saves;

    public PenaltyShotooutRegister(Player kicker, Player goalkeeper, int goals, int saves) {
        this.kicker = kicker;
        this.goalkeeper = goalkeeper;
        this.goals = goals;
        this.saves = saves;
    }

    public Player getKicker() {
        return kicker;
    }

    public Player getGoalkeeper() {
        return goalkeeper;
    }

    public int getGoals() {
        return goals;
    }

    public int getSaves() {
        return saves;
    }

    public void setKicker(Player kicker) {
        this.kicker = kicker;
    }

    public void setGoalkeeper(Player goalkeeper) {
        this.goalkeeper = goalkeeper;
    }

    public void setGoals(int goals) {
        this.goals = goals;
    }

    public void setatajadas(int atajadas) {
        this.saves = saves;
    }
}
