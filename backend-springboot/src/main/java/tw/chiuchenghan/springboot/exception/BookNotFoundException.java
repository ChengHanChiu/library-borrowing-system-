package tw.chiuchenghan.springboot.exception;

public class BookNotFoundException extends RuntimeException {

  public BookNotFoundException(String isbn) {
    super("Could not find employee " + isbn);
  }
}