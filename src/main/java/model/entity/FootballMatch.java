package model.entity;

public class FootballMatch extends Match {
    private Integer totalScore;
    private int homeFootballTeamScore = 0;
    private int awayFootballTeamScore = 0;

    private FootballMatch(FootballMatchBuilder builder) {
        super(builder.getHomeTeam(), builder.getAwayTeam());
        setHomeFootballTeamScore(builder.homeFootballTeamScore);
        setAwayFootballTeamScore(builder.awayFootballTeamScore);
        setTotalScore(builder.homeFootballTeamScore + builder.awayFootballTeamScore);
    }

    public static class FootballMatchBuilder extends Match {
        private Integer totalScore;
        private int homeFootballTeamScore = 0;
        private int awayFootballTeamScore = 0;

        @Override
        public void setTotalScore(int totalScore) {
            this.totalScore = totalScore;
        }

        public FootballMatchBuilder(Team homeFootballTeam, Team awayFootballTeam) {
            super(homeFootballTeam, awayFootballTeam);
            setTotalScore(0);
        }

        public FootballMatchBuilder addScore(int homeFootballTeamScore, int awayFootballTeamScore) {
            this.homeFootballTeamScore = homeFootballTeamScore;
            this.awayFootballTeamScore = awayFootballTeamScore;
            setTotalScore(homeFootballTeamScore + awayFootballTeamScore);
            return this;
        }

        public FootballMatch build() {
            FootballMatch footballMatch = new FootballMatch(this);
            return footballMatch;
        }
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
