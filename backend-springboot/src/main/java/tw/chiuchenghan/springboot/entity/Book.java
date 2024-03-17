package tw.chiuchenghan.springboot.entity;

import java.time.LocalDateTime;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.PrePersist;

import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;


@Entity
public
class Book{

  @Id
  //@Column(name = "Book_Id")
  private String ISBN;
  private String Name;
  private String Author;
  private String Introduction; 
  
  public Book() {}

  Book(String isbn, String name, String author, String intro) {
	this.ISBN = isbn;
    this.Name = name;
    this.Author = author;
    this.Introduction = intro;
  }

  public String getISBN() {
    return this.ISBN;
  }

  public String getName() {
    return this.Name;
  }

  public String getAuthor() {
    return this.Author;
  }
  
  public String getIntroduction() {
    return this.Introduction;
  }
  
  public void setISBN(String id) {
    this.ISBN = id;
  }
  
  public void setName(String name) {
    this.Name = name;
  }

  public void setAuthor(String author) {
    this.Author = author;
  }
  
  public void setIntroduction(String intro) {
    this.Introduction = intro;
  }

//  @Override
//  public boolean equals(Object o) {
//
//    if (this == o)
//      return true;
//    if (!(o instanceof Book))
//      return false;
//    Book Book = (Book) o;
//    return Objects.equals(this.BookId, Book.BookId) && Objects.equals(this.phoneNumber, Book.phoneNumber)
//        && Objects.equals(this.password, Book.password) && Objects.equals(this.BookName, Book.BookName);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(this.BookId, this.phoneNumber, this.password, this.BookName);
//  }
//
//  @Override
//  public String toString() {
//    return "Employee{" + "id=" + this.BookId + ", phoneNumber='" + this.phoneNumber + '\'' + ", password='" + this.password + '\'' + ", BookName='" + this.BookName +'}';
//  }
}