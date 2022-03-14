import model.FootballScoreBoard;
import model.entity.FootballMatch;
import model.entity.FootballTeam;
import model.entity.Match;
import org.junit.Test;
import util.exception.MatchAlreadyExistException;

import static org.junit.Assert.assertEquals;

public class FootballScoreBoardTest {
    @Test
    public void sizeOfFreeScoreBoard() {
        FootballScoreBoard footballScoreBoard = new FootballScoreBoard();
        assertEquals(0, footballScoreBoard.getSummary().size());
    }

    @Test
    public void sizeOfScoreBoardWithOneMatch() {
        FootballScoreBoard footballScoreBoard = new FootballScoreBoard();
        footballScoreBoard.startGame(new FootballMatch(new FootballTeam("Italy"), new FootballTeam("Norway")));
        assertEquals(1, footballScoreBoard.getSummary().size());
    }


}
