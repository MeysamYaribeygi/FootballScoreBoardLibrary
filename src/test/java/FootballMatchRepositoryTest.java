import model.FootballScoreBoard;
import model.entity.FootballMatch;
import model.entity.FootballTeam;
import model.repository.FootballMatchRepository;
import model.repository.MatchRepository;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.exception.*;

public class FootballMatchRepositoryTest {
    private MatchRepository footballMatchRepository = FootballMatchRepository.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(FootballMatchRepositoryTest.class);

    @Before
    public void initialization() {
        BasicConfigurator.configure();
        try {
            footballMatchRepository.addMatch(BuildMatch.getMatch("Mexico", "Canada"));
            footballMatchRepository.addMatch(BuildMatch.getMatch("Spain", "Brazil"));
            footballMatchRepository.addMatch(BuildMatch.getMatch("Germany", "France"));
            footballMatchRepository.addMatch(BuildMatch.getMatch("Uruguay", "Italy"));
            footballMatchRepository.addMatch(BuildMatch.getMatch("Argentina", "Australia"));
        } catch (MatchAlreadyExistException | TeamAlreadyExistException e) {
            logger.error(e.getMessage());
        }
    }

    @Test(expected = MatchAlreadyExistException.class)
    public void addSameMatchesReturnsMatchAlreadyExistException() throws MatchAlreadyExistException, TeamAlreadyExistException {
        footballMatchRepository.addMatch(BuildMatch.getMatch("Mexico", "Canada"));
    }

    @Test(expected = TeamAlreadyExistException.class)
    public void addMatchWithSameTeamInMatchesReturnsTeamAlreadyExistException() throws MatchAlreadyExistException, TeamAlreadyExistException {
        footballMatchRepository.addMatch(BuildMatch.getMatch("Mexico", "Finland"));
    }

    @Test(expected = MatchNotFoundException.class)
    public void updateNewMatchReturnsMatchNotFoundException() throws MatchNotFoundException, InvalidScoreException, TeamNotFoundException {
        footballMatchRepository.updateMatch(BuildMatch.getMatch("Norway", "Denmark", 1, 1));
    }

    @Test(expected = InvalidScoreException.class)
    public void updateMatchWithNegativeScoreReturnsInvalidScoreException() throws MatchNotFoundException, InvalidScoreException, TeamNotFoundException {
        footballMatchRepository.updateMatch(BuildMatch.getMatch("Mexico", "Canada", -1, 1));
    }

    @Test(expected = MatchNotFoundException.class)
    public void finishNewMatchReturnsMatchNotFoundException() throws MatchNotFoundException, InvalidScoreException, TeamNotFoundException {
        footballMatchRepository.removeMatch(BuildMatch.getMatch("Finland", "Sweden"));
    }
}
