package model;

import model.entity.Match;
import model.repository.FootballMatchRepository;

import java.util.ArrayList;

public class FootballScoreBoard {
    FootballMatchRepository matchRepository = new FootballMatchRepository();
    public ArrayList<Match> getSummary() {
        return FootballMatchRepository.getMatchesData();
    }

    public void startGame(Match match) {
        matchRepository.addMatch(match);
    }
}
