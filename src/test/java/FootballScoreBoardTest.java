import model.FootballScoreBoard;
import model.ScoreBoard;
import model.entity.FootballMatch;
import model.entity.Match;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class FootballScoreBoardTest {
    private static final Logger logger = LoggerFactory.getLogger(FootballScoreBoardTest.class);

    @Before
    public void initialization() {
        BasicConfigurator.configure();
    }

    @Test
    public void sizeOfFreeScoreBoard() {
        ScoreBoard footballScoreBoard = FootballScoreBoard.getScoreBoard();
        assertEquals(0, footballScoreBoard.getSummary().size());
    }

    @Test
    public void sizeOfScoreBoardWithOneMatch() {
        ScoreBoard footballScoreBoard = FootballScoreBoard.getScoreBoard();
        footballScoreBoard.startGame(BuildMatch.getMatch("Italy", "Norway"));
        assertEquals(1, footballScoreBoard.getSummary().size());
    }

    @Test
    public void getSummaryTest() {
        ScoreBoard footballScoreBoard = FootballScoreBoard.getScoreBoard();
        FootballMatch mexico0_canada5 = BuildMatch.getMatch("Mexico", "Canada");
        FootballMatch spain10_brazil2 = BuildMatch.getMatch("Spain", "Brazil");
        FootballMatch germany2_france2 = BuildMatch.getMatch("Germany", "France");
        FootballMatch uruguay6_italy6 = BuildMatch.getMatch("Uruguay", "Italy");
        FootballMatch argentina3_australia1 = BuildMatch.getMatch("Argentina", "Australia");

        footballScoreBoard.startGame(mexico0_canada5);
        footballScoreBoard.startGame(spain10_brazil2);
        footballScoreBoard.startGame(germany2_france2);
        footballScoreBoard.startGame(uruguay6_italy6);
        footballScoreBoard.startGame(argentina3_australia1);

        footballScoreBoard.updateScore(BuildMatch.getMatch("Mexico", "Canada", 0, 5));
        footballScoreBoard.updateScore(BuildMatch.getMatch("Spain", "Brazil", 10, 2));
        footballScoreBoard.updateScore(BuildMatch.getMatch("Germany", "France", 2, 2));
        footballScoreBoard.updateScore(BuildMatch.getMatch("Uruguay", "Italy", 6, 6));
        footballScoreBoard.updateScore(BuildMatch.getMatch("Argentina", "Australia", 3, 1));
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
