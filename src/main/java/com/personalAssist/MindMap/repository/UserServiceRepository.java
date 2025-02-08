package com.personalAssist.MindMap.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.personalAssist.MindMap.Model.UserServiceModal;

@Repository
public interface UserServiceRepository extends JpaRepository<UserServiceModal, Long>{
	
	Optional<UserServiceModal> findByServiceName(String name);

}
