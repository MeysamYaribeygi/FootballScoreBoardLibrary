package model.repository;

import model.entity.Team;
import util.exception.InvalidTeamNameException;
import util.exception.TeamAlreadyExistException;
import util.exception.TeamNotFoundException;

public interface TeamRepository {

    public Team getTeamByName(String name) throws TeamNotFoundException;

    public void addTeam(Team team) throws InvalidTeamNameException, TeamAlreadyExistException;

    public void removeTeam(Team team) throws TeamNotFoundException;
}
