package tw.chiuchenghan.springboot.exception;

public class UserNotFoundException extends RuntimeException {

   public UserNotFoundException(Long id) {
    super("Could not find user " + id);
  }
   public UserNotFoundException(String phoneNumber) {
    super("Could not find user " + phoneNumber);
  }
}