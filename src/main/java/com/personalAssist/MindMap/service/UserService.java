package com.personalAssist.MindMap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.personalAssist.MindMap.Model.Product;
import com.personalAssist.MindMap.Model.User;

@Component
public interface UserService {

	public User addUser(User product);
	public List<User> getAllUsers();
	public User getById(Long id);
	public String deleteUser(Long id);
	public Optional<User> updateUser(Long id, User updateUser);
}
	