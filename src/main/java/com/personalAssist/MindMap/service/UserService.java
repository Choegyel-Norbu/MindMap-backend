package com.personalAssist.MindMap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.personalAssist.MindMap.Model.Product;
import com.personalAssist.MindMap.Model.User;
import com.personalAssist.MindMap.dto.UserDTO;

@Component
public interface UserService {

	public UserDTO addUser(UserDTO userDTO);
	public List<User> getAllUsers();
	public User getById(Long id);
	public String deleteUser(Long id);
	public Optional<User> updateUser(Long id, User updateUser);
}
	