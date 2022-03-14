package util.exception;

public class InvalidTeamNameException extends Exception {
    public InvalidTeamNameException(String name) {
        super("Invalid name for: " + '"' + name + '"' + "\nThe name must contain only the letters and a maximum of 15" +
                " characters and must start with uppercase character.");
    }
}
