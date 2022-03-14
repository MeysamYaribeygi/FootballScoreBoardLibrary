package model.repository;

import model.entity.FootballMatch;
import model.entity.Match;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.exception.InvalidScoreException;
import util.exception.MatchAlreadyExistException;
import util.exception.MatchNotFoundException;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class FootballMatchRepository implements MatchRepository {
    private static final Logger logger = LoggerFactory.getLogger ( FootballMatchRepository.class );

    private static Map<String, Match> MATCHES_DATA = new HashMap<>();

    private static FootballMatchRepository obj = null;

    private FootballMatchRepository() {
    }

    public static MatchRepository getInstance() {
        if (obj == null)
            obj = new FootballMatchRepository();
        return obj;
    }

    public void addMatch(Match match) throws MatchAlreadyExistException {
        if (MATCHES_DATA.containsKey(match.getId()))
            throw new MatchAlreadyExistException();
        match.setInsertingTime(new Date());
        MATCHES_DATA.put(match.getId(), match);
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            logger.error(e.getMessage());
        }
    }

    @Override
    public void updateMatch(Match match) throws MatchNotFoundException, InvalidScoreException {
        if (((FootballMatch) match).getHomeFootballTeamScore() < 0)
            throw new InvalidScoreException(match.getHomeTeam().getName(), ((FootballMatch) match).getHomeFootballTeamScore());
        if (((FootballMatch) match).getAwayFootballTeamScore() < 0)
            throw new InvalidScoreException(match.getAwayTeam().getName(), ((FootballMatch) match).getAwayFootballTeamScore());
        Match m = getMatchById(match.getId());
        ((FootballMatch) m).setHomeFootballTeamScore(((FootballMatch) match).getHomeFootballTeamScore());
        ((FootballMatch) m).setAwayFootballTeamScore(((FootballMatch) match).getAwayFootballTeamScore());
        m.setTotalScore(((FootballMatch) match).getTotalScore());
    }

    @Override
    public Match getMatchById(String matchId) throws MatchNotFoundException {
        if (MATCHES_DATA.containsKey(matchId))
            return MATCHES_DATA.get(matchId);
        throw new MatchNotFoundException(matchId);
    }

    @Override
    public void removeMatch(Match match) throws MatchNotFoundException {
        if (!MATCHES_DATA.containsKey(match.getId()))
            throw new MatchNotFoundException(match.getId());
        MATCHES_DATA.remove(match.getId());
    }
    public static Map<String, Match> getMatchesData() {
        return MATCHES_DATA;
    }
}
