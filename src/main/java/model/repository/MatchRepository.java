package model.repository;

import model.entity.Match;
import util.exception.MatchAlreadyExistException;

public interface MatchRepository {
    public void addMatch(Match match) throws MatchAlreadyExistException;
}
