package Neat.and.Tidy.Solutions.cleaning.service.app.exception;

public class UserNotFoundException extends BusinessLogicException {
    public UserNotFoundException(String message) {
        super(message);
    }
}
