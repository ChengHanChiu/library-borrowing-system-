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
class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  //@Column(name = "User_Id")
  private Long userId;
  private String phoneNumber;
  private String password;
  private String userName;
  
  @CreatedDate
  @Column(updatable = false)
  private LocalDateTime registrationTime;
  
  @CreatedDate
  private LocalDateTime lastLoginTime;
  
  @PrePersist
  public void prePersist() {
      registrationTime = LocalDateTime.now();
      lastLoginTime = LocalDateTime.now();
  }
  
  public User() {}

  User(String phoneNo, String password, String userName) {
	this.phoneNumber = phoneNo;
    this.password = password;
    this.userName = userName;
  }

  public Long getId() {
    return this.userId;
  }

  public String getName() {
    return this.userName;
  }

  public String getPhoneNumber() {
    return this.phoneNumber;
  }
  
  public String getPassword() {
    return this.password;
  }
  
  public void setId(Long id) {
    this.userId = id;
  }
  
  public void setName(String name) {
    this.userName = name;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public boolean equals(Object o) {

    if (this == o)
      return true;
    if (!(o instanceof User))
      return false;
    User user = (User) o;
    return Objects.equals(this.userId, user.userId) && Objects.equals(this.phoneNumber, user.phoneNumber)
        && Objects.equals(this.password, user.password) && Objects.equals(this.userName, user.userName);
  }

  @Override
  public int hashCode() {
    return Objects.hash(this.userId, this.phoneNumber, this.password, this.userName);
  }

  @Override
  public String toString() {
    return "Employee{" + "id=" + this.userId + ", phoneNumber='" + this.phoneNumber + '\'' + ", password='" + this.password + '\'' + ", userName='" + this.userName +'}';
  }
}