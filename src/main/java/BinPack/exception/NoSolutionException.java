package BinPack.exception;

public class NoSolutionException extends Exception {
    public NoSolutionException() {
        super("No solution for this configuration");
    }
}
