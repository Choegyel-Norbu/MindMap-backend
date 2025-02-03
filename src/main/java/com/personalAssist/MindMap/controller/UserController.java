package com.personalAssist.MindMap.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.personalAssist.MindMap.Model.Product;
import com.personalAssist.MindMap.Model.User;
import com.personalAssist.MindMap.service.UserService;

@RestController
@RequestMapping("api/")
public class UserController {
	
	@Autowired
	UserService userService;
	
	@PostMapping("addUser")
	public User addUser(@RequestBody User product) {
		
		System.out.println("@@@ ------ reached in controller");
		User result = userService.addUser(product);
		if(result != null) {
			return result;
		}
		return null;
	}
	
	@GetMapping("getUsers")
	public List<User> getAllUsers() {
		return userService.getAllUsers();
	}
	
	@GetMapping("getUser/{id}")
	public User getById(@PathVariable Long id) {
		return userService.getById(id);
	}
	
	@DeleteMapping("deleteUser/{id}")
	public String deleteUser(@PathVariable Long id) {
		return userService.deleteUser(id);
	}
	
	@PatchMapping("updateUser/{id}")
	public Optional<User> updateUser(@PathVariable Long id, @RequestBody User product) {
		return userService.updateUser(id, product);
	}
}
