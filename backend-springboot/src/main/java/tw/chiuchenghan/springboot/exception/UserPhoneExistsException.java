package tw.chiuchenghan.springboot.exception;

public class UserPhoneExistsException extends RuntimeException {

  public UserPhoneExistsException(String tel) {
    super("該電話號碼已經被註冊:" + tel);
  }
}