package tw.chiuchenghan.springboot.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

//import LibraryBorrowingApplication.BookNotFoundException;

@ControllerAdvice
class BookNotFoundAdvice {

  @ResponseBody
  @ExceptionHandler(BookNotFoundException.class)
  @ResponseStatus(HttpStatus.NOT_FOUND)
  String BookNotFoundHandler(BookNotFoundException ex) {
    return ex.getMessage();
  }
}