import model.FootballScoreBoard;
import model.entity.Match;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FootballScoreBoardTest {
    @Test
    public void sizeOfFreeScoreBoard(){
        FootballScoreBoard footballScoreBoard = new FootballScoreBoard();
        assertEquals(0,footballScoreBoard.getSummary().size());
    }
    @Test
    public void sizeOfScoreBoardWithOneMatch(){
        FootballScoreBoard footballScoreBoard = new FootballScoreBoard();
        footballScoreBoard.startGame(new Match());
        assertEquals(1,footballScoreBoard.getSummary().size());
    }

}
