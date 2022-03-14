package util.exception;

public class InvalidScoreException extends Exception {
    public InvalidScoreException(String teamName, int score) {
        super("Invalid score " + '(' + score + ')' + " for "+'"' + teamName + '"' +"\nThe score must be greater than or equal to zero");
    }
}
