package tw.chiuchenghan.springboot.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import tw.chiuchenghan.springboot.repository.UserRepository;

@Configuration
class LoadDatabase {
	
  private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
  
  @Bean
  CommandLineRunner initDatabase(UserRepository userRepository) {

    return args -> {
//      bookRepository.save(new Book("9789573317241", "哈利波特", "J.K羅琳", "在世界的另一個角落裡，有一個神秘的國度..."));
//      bookRepository.save(new Book("9789863615460", "富爸爸，窮爸爸", " 羅勃特‧T‧清崎", "《富爸爸，窮爸爸》的架構圍繞在作者羅勃特‧T‧清崎童年時，兩位爸爸教他..."));
      //bookRepository.save(new Book("Frodo Baggins", "thief"));
      
//      bookRepository.findAll().forEach(book -> log.info("Preloaded " + book));
      
//      userRepository.save(new User("0912345678", "password", "user1"));
//      userRepository.save(new User("0912345678", "password", "user2"));

      //userRepository.findAll().forEach(user -> { log.info("Preloaded " + user);});
      
//      orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
//      orderRepository.save(new Order("iPhone", Status.IN_PROGRESS));
//
//      orderRepository.findAll().forEach(order -> {
//        log.info("Preloaded " + order);
//      });
    };
  }
}