package model.repository;

import model.entity.Match;
import util.exception.InvalidScoreException;
import util.exception.MatchAlreadyExistException;
import util.exception.MatchNotFoundException;

public interface MatchRepository {
    public void addMatch(Match match) throws MatchAlreadyExistException;

    public void updateMatch(Match match) throws MatchNotFoundException, InvalidScoreException;

    public Match getMatchById(String matchId) throws MatchNotFoundException;


}
