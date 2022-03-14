package util.exception;

public class TeamNotFoundException extends Exception {
    public TeamNotFoundException(String name) {
        super("Team named " + '"' + name + '"' + "not found in the repository!");
    }
}
