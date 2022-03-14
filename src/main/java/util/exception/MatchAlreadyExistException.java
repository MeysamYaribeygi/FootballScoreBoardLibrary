package util.exception;

public class MatchAlreadyExistException extends Exception {
    public MatchAlreadyExistException() {
        super("Match already exist in the repository!");
    }
}
