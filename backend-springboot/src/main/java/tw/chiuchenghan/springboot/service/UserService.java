package tw.chiuchenghan.springboot.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import tw.chiuchenghan.springboot.entity.User;
import tw.chiuchenghan.springboot.entity.UserDto;
import tw.chiuchenghan.springboot.exception.InvalidPasswordException;
import tw.chiuchenghan.springboot.exception.UserPhoneExistsException;
import tw.chiuchenghan.springboot.repository.UserRepository;




@Service
public class UserService {
	
	@Autowired
	private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    @Autowired
    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }
    
    public User registerUser(UserDto userDto) throws UserPhoneExistsException{
    	if (userRepository.existsByphoneNumber(userDto.getPhoneNumber())) {
            throw new UserPhoneExistsException("電話號碼已經被註冊");
        }
    	if (!userDto.getPassword().equals(userDto.getMatchingPassword())) {
    		System.out.println(userDto.getPassword());
    		System.out.println(userDto.getMatchingPassword());
            throw new UserPhoneExistsException("密碼不相同");
        }
    	User user = new User();
    	user.setPhoneNumber(userDto.getPhoneNumber());
    	user.setName(userDto.getUserName());
    	user.setPassword(passwordEncoder.encode(userDto.getPassword()));;
        return userRepository.save(user);
    }
    
    public boolean verifyPassword(String phoneNumber, String password) {
        User user = userRepository.findByPhoneNumber(phoneNumber)
                .orElseThrow(() -> new RuntimeException("User not found with phone number: " + phoneNumber));
        if (!passwordEncoder.matches(password, user.getPassword())) {
            throw new InvalidPasswordException("Invalid password");
        }

        return true;
    }
}
