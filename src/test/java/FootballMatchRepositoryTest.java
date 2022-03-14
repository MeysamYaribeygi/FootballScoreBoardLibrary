import model.FootballScoreBoard;
import model.entity.FootballMatch;
import model.entity.FootballTeam;
import model.repository.FootballMatchRepository;
import org.junit.Test;
import util.exception.MatchAlreadyExistException;

public class FootballMatchRepositoryTest {
    @Test(expected = MatchAlreadyExistException.class)
    public void addSameMatchesReturnsMatchAlreadyExistException() throws MatchAlreadyExistException {
        FootballMatchRepository footballMatchRepository = new FootballMatchRepository();
        footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Italy"), new FootballTeam("Norway")));
        footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Italy"), new FootballTeam("Norway")));
    }
}
