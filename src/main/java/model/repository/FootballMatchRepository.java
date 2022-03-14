package model.repository;

import model.entity.Match;
import util.exception.MatchAlreadyExistException;

import java.util.HashMap;
import java.util.Map;

public class FootballMatchRepository implements MatchRepository {
    private static Map<String, Match> MATCHES_DATA = new HashMap<>();

    public void addMatch(Match match) throws MatchAlreadyExistException {
        if (MATCHES_DATA.containsKey(match.getId()))
            throw new MatchAlreadyExistException();
        MATCHES_DATA.put(match.getId(), match);
    }

    public static Map<String, Match> getMatchesData() {
        return MATCHES_DATA;
    }

}
