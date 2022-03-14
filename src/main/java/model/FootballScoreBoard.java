package model;

import model.entity.Match;
import model.repository.FootballMatchRepository;
import util.exception.MatchAlreadyExistException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class FootballScoreBoard {
    FootballMatchRepository matchRepository = new FootballMatchRepository();

    public List<Match> getSummary() {
        List<Match> matches = FootballMatchRepository.getMatchesData().values().stream().collect(Collectors.toCollection(ArrayList::new));
        return matches;
    }
    public void startGame(Match match) {
        try {
            matchRepository.addMatch(match);
        } catch (MatchAlreadyExistException e) {
            e.printStackTrace();
        }
    }
}
