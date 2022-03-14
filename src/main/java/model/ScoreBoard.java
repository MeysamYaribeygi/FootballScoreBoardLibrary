package model;

import model.entity.Match;

import java.util.List;

public interface ScoreBoard {
    public void startGame(Match match);

    public void updateScore(Match match);

    public void finishGame(Match match);

    public List<Match> getSummary();
}
