import model.entity.FootballTeam;
import model.repository.FootballTeamRepository;
import model.repository.TeamRepository;
import org.junit.Before;
import org.junit.Test;
import util.exception.InvalidTeamNameException;
import util.exception.TeamAlreadyExistException;
import util.exception.TeamNotFoundException;

public class FootballTeamRepositoryTest {
    private TeamRepository teamRepository = FootballTeamRepository.getInstance();

    @Before
    public void teamRepositoryInitialization() {
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
            e.printStackTrace();
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
    public void TeamNameIncludeNumbersReturnsInvalidTeamNameException() throws InvalidTeamNameException,TeamAlreadyExistException {
        teamRepository.addTeam(new FootballTeam("Norway1"));
    }

    @Test(expected = InvalidTeamNameException.class)
    public void TeamNameIncludeSignsReturnsInvalidTeamNameException() throws InvalidTeamNameException,TeamAlreadyExistException {
        teamRepository.addTeam(new FootballTeam("Nor@way"));
    }

    @Test(expected = InvalidTeamNameException.class)
    public void TeamNameStartWithLowercaseReturnsInvalidTeamNameException() throws InvalidTeamNameException,TeamAlreadyExistException {
        teamRepository.addTeam(new FootballTeam("norway"));
    }
}
