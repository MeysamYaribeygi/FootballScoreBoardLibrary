package model.entity;

public class FootballMatch extends Match {
    private Integer totalScore;
    private int homeFootballTeamScore = 0;
    private int awayFootballTeamScore = 0;

    public FootballMatch(Team homeFootballTeam, Team awayFootballTeam) {
        super(homeFootballTeam, awayFootballTeam);
        setTotalScore(0);
    }

    public FootballMatch(Team homeFootballTeam, Team awayFootballTeam,
                                 int homeFootballTeamScore, int awayFootballTeamScore) {
        super(homeFootballTeam, awayFootballTeam);
        setHomeFootballTeamScore(homeFootballTeamScore);
        setAwayFootballTeamScore(awayFootballTeamScore);
        setTotalScore(homeFootballTeamScore + awayFootballTeamScore);
    }

    @Override
    public void setTotalScore(int totalScore) {
        this.totalScore = totalScore;
    }

    public Integer getTotalScore() {
        return totalScore;
    }

    public int getHomeFootballTeamScore() {
        return homeFootballTeamScore;
    }

    public void setHomeFootballTeamScore(int homeFootballTeamScore) {
        this.homeFootballTeamScore = homeFootballTeamScore;
    }

    public int getAwayFootballTeamScore() {
        return awayFootballTeamScore;
    }

    public void setAwayFootballTeamScore(int awayFootballTeamScore) {
        this.awayFootballTeamScore = awayFootballTeamScore;
    }
}
