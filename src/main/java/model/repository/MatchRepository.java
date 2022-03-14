package model.repository;

import model.entity.Match;
import util.exception.InvalidScoreException;
import util.exception.MatchAlreadyExistException;
import util.exception.MatchNotFoundException;
import util.exception.TeamAlreadyExistException;

public interface MatchRepository {
    public void addMatch(Match match) throws MatchAlreadyExistException, TeamAlreadyExistException;

    public void updateMatch(Match match) throws MatchNotFoundException, InvalidScoreException;

    public Match getMatchById(String matchId) throws MatchNotFoundException;

    public void removeMatch(Match match) throws MatchNotFoundException;



}
