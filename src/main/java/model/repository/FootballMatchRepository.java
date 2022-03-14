package model.repository;

import model.entity.Match;

import java.util.ArrayList;

public class FootballMatchRepository {
    private static ArrayList<Match> MATCHES_DATA = new ArrayList<>();

    public void addMatch(Match match){
        MATCHES_DATA.add(match);
    }

    public static ArrayList<Match> getMatchesData() {
        return MATCHES_DATA;
    }

}
