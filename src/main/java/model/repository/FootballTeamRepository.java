package model.repository;

import model.entity.Team;
import util.exception.InvalidTeamNameException;
import util.exception.TeamAlreadyExistException;
import util.exception.TeamNotFoundException;

import java.util.regex.*;
import java.util.HashMap;
import java.util.Map;

public class FootballTeamRepository implements TeamRepository {
    private static Map<String, Team> TEAM_DATA = new HashMap<String, Team>();
    private static FootballTeamRepository obj = null;

    private FootballTeamRepository() {
    }

    public static TeamRepository getInstance() {
        if (obj == null)
            obj = new FootballTeamRepository();
        return obj;
    }

    public Team getTeamByName(String name) throws TeamNotFoundException {
        if (TEAM_DATA.containsKey(name))
            return TEAM_DATA.get(name);
        throw new TeamNotFoundException(name);
    }

    public void addTeam(Team team) throws InvalidTeamNameException, TeamAlreadyExistException {
        nameValidation(team.getName());
        if (TEAM_DATA.containsKey(team.getName()))
            throw new TeamAlreadyExistException(team.getName());
        TEAM_DATA.put(team.getName(), team);
    }

    public void removeTeam(Team team) throws TeamNotFoundException {
        if (!TEAM_DATA.containsKey(team.getName()))
            throw new TeamNotFoundException(team.getName());
        TEAM_DATA.remove(team.getName());
    }

    public void nameValidation(String name) throws InvalidTeamNameException {
        if (!Pattern.matches("[A-Z]{1}[a-zA-Z]{2,19}", name))
            throw new InvalidTeamNameException(name);
    }
}
