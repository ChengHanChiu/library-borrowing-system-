package tw.chiuchenghan.springboot.entity;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


public class UserDto {
	
	@NotNull
    @NotEmpty
    private String name;
	
	@NotNull
	@NotEmpty
    private String telephone;
    
	/*
	@ValidEmail
    @NotNull
    @NotEmpty
    private String email;
	*/
	
	@NotNull
    @NotEmpty
    private String password;
	
	@NotNull
    @NotEmpty
    private String matchingPassword;
    
    
    
    
    public UserDto() {
    }

    public UserDto(String telephone, String password, String userName) {
        this.telephone = telephone;
        this.password = password;
        this.name = userName;
    }

    // Getters and Setters...

    public String getPhoneNumber() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getMatchingPassword() {
        return matchingPassword;
    }

    public void setMatchingPassword(String password) {
        this.matchingPassword = password;
    }
    
    public String getUserName() {
        return name;
    }

    public void setUserName(String userName) {
        this.name = userName;
    }

}