package model.entity;

public abstract class Match {
    private String id;
    private Team homeTeam;
    private Team awayTeam;

    public Match() {
    }
    public Match(Team homeTeam, Team awayTeam) {
        this.homeTeam = homeTeam;
        this.awayTeam = awayTeam;
        setId();
    }

    public String getId() {
        return id;
    }

    public void setId() {
        this.id = homeTeam.getName() + " - " + awayTeam.getName();
    }

    public Team getHomeTeam() {
        return homeTeam;
    }

    public void setHomeTeam(Team homeTeam) {
        this.homeTeam = homeTeam;
    }

    public Team getAwayTeam() {
        return awayTeam;
    }

    public void setAwayTeam(Team awayTeam) {
        this.awayTeam = awayTeam;
    }


}
