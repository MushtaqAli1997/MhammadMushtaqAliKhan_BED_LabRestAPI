package com.greatlearning.StudentDetails.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.greatlearning.StudentDetails.model.User;

public interface UserRepository extends JpaRepository<User, Integer>{	
	
	@Query("Select u FROM User u WHERE u.username = ?1")
	public User getUserByUserName(String username);

}
