package TandaPenaltis;

public class MatchHistoryDTO {

    private final String kickerName;
    private final String goalkeeperName;
    private final int goals;
    private final int saves;

    MatchHistoryDTO(String kickerName, String goalkeeperName, int goals, int saves) {
        this.kickerName = kickerName;
        this.goalkeeperName = goalkeeperName;
        this.goals = goals;
        this.saves = saves;
    }

    public String getKickerName() {
        return kickerName;
    }

    public String getGoalkeeperName() {
        return goalkeeperName;
    }

    public int getGoals() {
        return goals;
    }

    public int getSaves() {
        return saves;
    }
}
