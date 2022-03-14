package model;

import model.entity.FootballMatch;
import model.entity.Match;
import model.repository.FootballMatchRepository;
import model.repository.MatchRepository;
import util.exception.InvalidScoreException;
import util.exception.MatchAlreadyExistException;
import util.exception.MatchNotFoundException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class FootballScoreBoard implements ScoreBoard {
    private MatchRepository matchRepository = FootballMatchRepository.getInstance();
    private static FootballScoreBoard obj = null;

    private FootballScoreBoard() {
    }

    public static ScoreBoard getScoreBoard() {
        if (obj == null)
            obj = new FootballScoreBoard();
        return obj;
    }
    @Override
    public void startGame(Match match) {
        try {
            matchRepository.addMatch(match);
        } catch (MatchAlreadyExistException e) {
            e.printStackTrace();
        }
    }
    @Override
    public void updateScore(Match match) {
        try {
            matchRepository.updateMatch(match);
        } catch (MatchNotFoundException e) {
            e.printStackTrace();
        } catch (InvalidScoreException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void finishGame(Match match) {
        try {
            matchRepository.removeMatch(match);
        } catch (MatchNotFoundException e) {
            e.printStackTrace();
        }
    }
    @Override
    public List<Match> getSummary() {
        List<Match> matches = FootballMatchRepository.getMatchesData().values().stream().collect(Collectors.toCollection(ArrayList::new));
        Collections.sort(matches, (m1, m2) -> {
            int compare;
            if (((FootballMatch) m1).getTotalScore() == null || ((FootballMatch) m2).getTotalScore() == null)
                compare = 0;
            else
                compare = ((FootballMatch) m2).getTotalScore().compareTo(((FootballMatch) m1).getTotalScore());
            if (compare == 0 && m1.getInsertingTime() != null && m2.getInsertingTime() != null) {
                compare = m2.getInsertingTime().compareTo(m1.getInsertingTime());
            }
            return compare;
        });
        return matches;
    }
}
