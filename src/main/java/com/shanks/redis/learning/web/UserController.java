package com.shanks.redis.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shanks.redis.learning.domain.User;
import com.shanks.redis.learning.service.UserService;

@RestController
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public Object user(User user, @PageableDefault Pageable pageable) {
		return userService.listUser(user, pageable);
	}
	
	@RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
	public Object user(@PathVariable Long id) {
		return userService.findById(id);
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.POST)
	public Object save(User user) {
		return userService.save(user);
	}
	
}
