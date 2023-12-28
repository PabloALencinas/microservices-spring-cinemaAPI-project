package com.pabloagustin.user;

import com.pabloagustin.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
	Boolean existsByEmail(String email);
}
