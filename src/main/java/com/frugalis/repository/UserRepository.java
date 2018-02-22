package com.frugalis.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.frugalis.entity.User;


public interface UserRepository extends JpaRepository<User, Long>{
	
	List<User> findByfirstname(String firstname);
	User findById(Long Id);
}
