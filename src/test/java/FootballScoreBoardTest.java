import model.FootballScoreBoard;
import model.ScoreBoard;
import model.entity.FootballMatch;
import model.entity.FootballTeam;
import model.entity.Match;
import org.junit.Before;
import org.junit.Test;
import util.exception.MatchAlreadyExistException;

import static org.junit.Assert.assertArrayEquals;


import static org.junit.Assert.assertEquals;

public class FootballScoreBoardTest {

    @Test
    public void sizeOfFreeScoreBoard() {
        ScoreBoard footballScoreBoard = FootballScoreBoard.getScoreBoard();
        assertEquals(0, footballScoreBoard.getSummary().size());
    }

    @Test
    public void sizeOfScoreBoardWithOneMatch() {
        ScoreBoard footballScoreBoard = FootballScoreBoard.getScoreBoard();
        footballScoreBoard.startGame(new FootballMatch(new FootballTeam("Italy"), new FootballTeam("Norway")));
        assertEquals(1, footballScoreBoard.getSummary().size());
    }

    @Test
    public void getSummaryTest() {
        ScoreBoard footballScoreBoard = FootballScoreBoard.getScoreBoard();

        FootballMatch mexico0_canada5 = new FootballMatch(new FootballTeam("Mexico"), new FootballTeam("Canada"), 0, 5);
        FootballMatch spain10_brazil2 = new FootballMatch(new FootballTeam("Spain"), new FootballTeam("Brazil"), 10, 2);
        FootballMatch germany2_france2 = new FootballMatch(new FootballTeam("Germany"), new FootballTeam("France"), 2, 2);
        FootballMatch uruguay6_italy6 = new FootballMatch(new FootballTeam("Uruguay"), new FootballTeam("Italy"), 6, 6);
        FootballMatch argentina3_australia1 = new FootballMatch(new FootballTeam("Argentina"), new FootballTeam("Australia"), 3, 1);

        footballScoreBoard.startGame(mexico0_canada5);
        footballScoreBoard.startGame(spain10_brazil2);
        footballScoreBoard.startGame(germany2_france2);
        footballScoreBoard.startGame(uruguay6_italy6);
        footballScoreBoard.startGame(argentina3_australia1);

        Match[] expectedArray = {
                uruguay6_italy6,
                spain10_brazil2,
                mexico0_canada5,
                argentina3_australia1,
                germany2_france2
        };
        assertArrayEquals(expectedArray, footballScoreBoard.getSummary().toArray());
    }

}
