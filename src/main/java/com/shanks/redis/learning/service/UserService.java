package com.shanks.redis.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shanks.redis.learning.domain.User;
import com.shanks.redis.learning.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;
	
	public List<User> listUser(User user, Pageable pageable) {
		return userRepository.listUser(user);
	}
	
	public User findById(Long id) {
		return userRepository.findById(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public User save(User user) {
		userRepository.save(user);
		return user;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Long id) {
		userRepository.delete(id);
	}
}
