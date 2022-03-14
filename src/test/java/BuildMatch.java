import model.entity.FootballMatch;
import model.entity.FootballTeam;
import util.exception.TeamNotFoundException;

public class BuildMatch {
    public static FootballMatch getMatch(String homeTeamName, String awayTeamName) {
        return new FootballMatch.FootballMatchBuilder(new FootballTeam(homeTeamName), new FootballTeam(awayTeamName)).build();
    }

    public static FootballMatch getMatch(String homeTeamName, String awayTeamName, int homeTeamScore, int awayTeamScore) {
        return new FootballMatch.FootballMatchBuilder(new FootballTeam(homeTeamName), new FootballTeam(awayTeamName)).addScore(homeTeamScore, awayTeamScore).build();
    }
}
