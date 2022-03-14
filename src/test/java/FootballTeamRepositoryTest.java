import model.entity.FootballTeam;
import model.repository.FootballTeamRepository;
import model.repository.TeamRepository;
import org.apache.log4j.BasicConfigurator;
import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import util.exception.InvalidTeamNameException;
import util.exception.TeamAlreadyExistException;
import util.exception.TeamNotFoundException;

public class FootballTeamRepositoryTest {
    private TeamRepository teamRepository = FootballTeamRepository.getInstance();
    private static final Logger logger = LoggerFactory.getLogger(FootballTeamRepositoryTest.class);

    @Before
    public void initialization() {
        BasicConfigurator.configure();
        try {
            teamRepository.addTeam(new FootballTeam("Mexico"));
            teamRepository.addTeam(new FootballTeam("Canada"));
            teamRepository.addTeam(new FootballTeam("Spain"));
            teamRepository.addTeam(new FootballTeam("Brazil"));
            teamRepository.addTeam(new FootballTeam("Germany"));
            teamRepository.addTeam(new FootballTeam("France"));
            teamRepository.addTeam(new FootballTeam("Uruguay"));
            teamRepository.addTeam(new FootballTeam("Italy"));
            teamRepository.addTeam(new FootballTeam("Argentina"));
            teamRepository.addTeam(new FootballTeam("Australia"));
        } catch (TeamAlreadyExistException | InvalidTeamNameException e) {
            logger.error(e.getMessage());
        }
    }

    @Test(expected = TeamAlreadyExistException.class)
    public void addSameTeamReturnsTeamAlreadyExistException() throws TeamAlreadyExistException, InvalidTeamNameException {
        teamRepository.addTeam(new FootballTeam("Mexico"));
    }

    @Test(expected = TeamNotFoundException.class)
    public void removeNewTeamReturnsTeamNotFoundException() throws TeamNotFoundException {
        teamRepository.removeTeam(new FootballTeam("Norway"));
    }

    @Test(expected = InvalidTeamNameException.class)
    public void TeamNameIncludedNumbersReturnsInvalidTeamNameException() throws InvalidTeamNameException, TeamAlreadyExistException {
        teamRepository.addTeam(new FootballTeam("Norway1"));
    }

    @Test(expected = InvalidTeamNameException.class)
    public void TeamNameIncludedSignsReturnsInvalidTeamNameException() throws InvalidTeamNameException, TeamAlreadyExistException {
        teamRepository.addTeam(new FootballTeam("Nor@way"));
    }

    @Test(expected = InvalidTeamNameException.class)
    public void TeamNameStartedWithLowercaseReturnsInvalidTeamNameException() throws InvalidTeamNameException, TeamAlreadyExistException {
        teamRepository.addTeam(new FootballTeam("norway"));
    }
}
