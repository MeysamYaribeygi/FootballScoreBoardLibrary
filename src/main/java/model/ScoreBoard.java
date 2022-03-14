package model;

import model.entity.Match;

import java.util.List;

public interface ScoreBoard {
    public List<Match> getSummary();

    public void startGame(Match match);
}
