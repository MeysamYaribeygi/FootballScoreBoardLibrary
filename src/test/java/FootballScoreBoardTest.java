import model.FootballScoreBoard;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class FootballScoreBoardTest {
    @Test
    public void freeScoreBoardSizeReturnZero(){
        FootballScoreBoard footballScoreBoard = new FootballScoreBoard();
        assertEquals(0,footballScoreBoard.getSummary().size());
    }
}
