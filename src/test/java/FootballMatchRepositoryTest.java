import model.FootballScoreBoard;
import model.entity.FootballMatch;
import model.entity.FootballTeam;
import model.repository.FootballMatchRepository;
import org.junit.Before;
import org.junit.Test;
import util.exception.InvalidScoreException;
import util.exception.MatchAlreadyExistException;
import util.exception.MatchNotFoundException;

public class FootballMatchRepositoryTest {
    FootballMatchRepository footballMatchRepository = new FootballMatchRepository();

    @Before
    public void matchRepositoryInitialization() {
        try {
            footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Mexico"), new FootballTeam("Canada")));
            footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Spain"), new FootballTeam("Brazil")));
            footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Germany"), new FootballTeam("France")));
            footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Uruguay"), new FootballTeam("Italy")));
            footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Argentina"), new FootballTeam("Australia")));
        } catch (MatchAlreadyExistException e) {
            e.printStackTrace();
        }

    }

    @Test(expected = MatchAlreadyExistException.class)
    public void addSameMatchesReturnsMatchAlreadyExistException() throws MatchAlreadyExistException {
        footballMatchRepository.addMatch(new FootballMatch(new FootballTeam("Mexico"), new FootballTeam("Canada")));
    }

    @Test(expected = MatchNotFoundException.class)
    public void updateNewMatchReturnsMatchNotFoundException() throws MatchNotFoundException, InvalidScoreException {
        footballMatchRepository.updateMatch(new FootballMatch(new FootballTeam("Norway"), new FootballTeam("Denmark"), 1, 1));
    }

    @Test(expected = InvalidScoreException.class)
    public void updateMatchWithNegativeScoreReturnsInvalidScoreException() throws MatchNotFoundException, InvalidScoreException {
        footballMatchRepository.updateMatch(new FootballMatch(new FootballTeam("Mexico"), new FootballTeam("Canada"), -1, 1));
    }

    @Test(expected = MatchNotFoundException.class)
    public void finishNewMatchReturnsMatchNotFoundException() throws MatchNotFoundException, InvalidScoreException {
        footballMatchRepository.updateMatch(new FootballMatch(new FootballTeam("Finland"), new FootballTeam("Sweden")));
    }
}
