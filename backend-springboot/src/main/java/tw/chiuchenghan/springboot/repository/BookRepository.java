package tw.chiuchenghan.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.chiuchenghan.springboot.entity.Book;
import tw.chiuchenghan.springboot.entity.User;

public interface BookRepository extends JpaRepository<Book, String> {
//	boolean existsByphoneNumber(String phoneNumber);
//
	Optional<Book> findByISBN(String isbn);

}