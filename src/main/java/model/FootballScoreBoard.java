package model;

import model.entity.Match;
import model.repository.FootballMatchRepository;
import util.exception.InvalidScoreException;
import util.exception.MatchAlreadyExistException;
import util.exception.MatchNotFoundException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FootballScoreBoard {
    FootballMatchRepository matchRepository = new FootballMatchRepository();

    public void startGame(Match match) {
        try {
            matchRepository.addMatch(match);
        } catch (MatchAlreadyExistException e) {
            e.printStackTrace();
        }
    }

    public void updateScore(Match match) {
        try {
            matchRepository.updateMatch(match);
        } catch (MatchNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidScoreException e) {
            e.printStackTrace();
        }
    }

    public void finishGame(Match match) {
        try {
            matchRepository.removeMatch(match);
        } catch (MatchNotFoundException e) {
            e.printStackTrace();
        }
    }

    public List<Match> getSummary() {
        List<Match> matches = FootballMatchRepository.getMatchesData().values().stream().collect(Collectors.toCollection(ArrayList::new));
        return matches;
    }
}
