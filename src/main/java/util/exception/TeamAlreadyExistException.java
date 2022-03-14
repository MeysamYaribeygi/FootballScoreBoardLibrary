package util.exception;

public class TeamAlreadyExistException extends Exception {
    public TeamAlreadyExistException(String name) {
        super("Team named " + '"' + name + '"' + " already exist in the repository!");
    }
}
