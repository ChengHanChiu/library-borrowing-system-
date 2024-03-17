package tw.chiuchenghan.springboot.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import tw.chiuchenghan.springboot.entity.Inventory;

public interface InventoryRepository extends JpaRepository<Inventory, Long> {
//	boolean existsByphoneNumber(String phoneNumber);
//
//	Optional<User> findByPhoneNumber(String phoneNumber);

}