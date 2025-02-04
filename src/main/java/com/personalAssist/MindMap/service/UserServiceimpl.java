package com.personalAssist.MindMap.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.personalAssist.MindMap.Model.Product;
import com.personalAssist.MindMap.Model.User;
import com.personalAssist.MindMap.dto.UserDTO;
import com.personalAssist.MindMap.repository.ProductRepository;
import com.personalAssist.MindMap.repository.UserRepository;
import com.personalAssist.MindMap.util.PasswordEncoder;
import com.personalAssist.MindMap.util.UserWrapper;

@Service
public class UserServiceimpl implements UserService{
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDTO addUser(UserDTO userDTO) {
		User user = UserWrapper.toEntity(userDTO);
		user.setPassword(PasswordEncoder.encode(userDTO.getPassword()));
		
		return UserWrapper.toDTO(userRepository.save(user));
	}

	@Override
	public List<User> getAllUsers() {
		return userRepository.findAll();
	}


	@Override
	public Optional<User> updateUser(Long id, User updateUser) {
		return userRepository.findById(id).map((user) -> {
			user.setFirstName(updateUser.getFirstName());
			user.setLastName(updateUser.getLastName());
			user.setPassword(updateUser.getPassword());
			user.setEmail(updateUser.getEmail());
			user.setPhone(updateUser.getPhone());
			user.setCreatedAt(updateUser.getCreatedAt());
			user.setUpdatedAt(updateUser.getUpdatedAt());
			return userRepository.save(user);
			
		});
	}

	@Override
	public User getById(Long id) {
		return userRepository.findById(id).orElse(null);
	}

	@Override
	public String deleteUser(Long id) {
		// TODO Auto-generated method stub
		User checkProduct = userRepository.findById(id).orElse(null);
		if(checkProduct !=  null) {
			userRepository.deleteById(id);
			return "Product id "+ id + " deleted";
		}
		
		return "The product id "+ id +" doesnot exist";
	}


}


