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
class Inventory {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //@Column(name = "User_Id")
  private Long Inventory_Id;
  private String ISBN;
  private String Status;
  
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime Store_Time;
  
  @PrePersist
  public void prePersist() {
	  Store_Time = LocalDateTime.now();
  }
  
  public Inventory() {}

  Inventory(Long id, String isbn, String status) {
	this.Inventory_Id = id;
    this.ISBN = isbn;
    this.Status = status;
  }

  public Long getId() {
    return this.Inventory_Id;
  }

  public String getISBN() {
    return this.ISBN;
  }

  public String getStatus() {
    return this.Status;
  }
  
  public void setId(Long id) {
    this.Inventory_Id = id;
  }
  
  public void setISBN(String isbn) {
    this.ISBN = isbn;
  }

  public void setStatue(String status) {
    this.Status = status;
  }
  
 

//  @Override
//  public boolean equals(Object o) {
//
//    if (this == o)
//      return true;
//    if (!(o instanceof User))
//      return false;
//    User user = (User) o;
//    return Objects.equals(this.userId, user.userId) && Objects.equals(this.phoneNumber, user.phoneNumber)
//        && Objects.equals(this.password, user.password) && Objects.equals(this.userName, user.userName);
//  }
//
//  @Override
//  public int hashCode() {
//    return Objects.hash(this.userId, this.phoneNumber, this.password, this.userName);
//  }
//
//  @Override
//  public String toString() {
//    return "Employee{" + "id=" + this.userId + ", phoneNumber='" + this.phoneNumber + '\'' + ", password='" + this.password + '\'' + ", userName='" + this.userName +'}';
//  }
}