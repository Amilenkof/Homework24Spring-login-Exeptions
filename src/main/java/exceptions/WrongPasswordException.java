package exceptions;

public class WrongPasswordException extends RuntimeException{
    public WrongPasswordException(String messag) {
        super(messag);
    }
}
