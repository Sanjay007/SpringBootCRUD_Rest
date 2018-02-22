package com.frugalis.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.frugalis.beans.User;
import com.frugalis.service.UserService;
import com.mysql.cj.fabric.Response;

@RestController
public class HelloController {

	@Autowired
	UserService userService;
	
	
	@PostMapping("/users")
	public User save(@RequestBody User u) {
		return userService.saveUser(u);
	}
	
	@GetMapping("/users")
	public ResponseEntity<Object> getAll() {
		
		return  ResponseEntity.ok().body(userService.getAllUsers());
 
	}
	
	@GetMapping("/users/{id}")
	public ResponseEntity<User> getUserById(@PathVariable(value = "id") Long userId) {
	    User user = userService.findbyId(userId);
	    if(user == null) {
	        return ResponseEntity.notFound().build();
	    }
	    return ResponseEntity.ok().body(user);
	}
	
	@PutMapping("/users/{id}")
	public ResponseEntity<Object> updateUser(@PathVariable(value = "id") Long userId,@RequestBody User inUser) {
		inUser.setId(userId);
		User user = userService.updateUser(inUser);
	    if(user == null) {
	        return ResponseEntity.ok().body(new String("Not Found"));
	    }
	    return ResponseEntity.ok().body(user);
	}
	
	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable(value = "id") Long userId) {
		
		int  user = userService.deleteUser(userId);
	    if(user<=0) {
	        return ResponseEntity.ok().body(new String("Not Found"));
	    }
	    return ResponseEntity.ok().body(new String("Deleted SuccessFully"));
	}
	
	
}
