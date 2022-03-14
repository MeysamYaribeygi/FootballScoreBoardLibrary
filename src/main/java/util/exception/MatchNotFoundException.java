package util.exception;

public class MatchNotFoundException extends Exception {
    public MatchNotFoundException(String matchId) {
        super(matchId + " match not found in the repository!");
    }
}
