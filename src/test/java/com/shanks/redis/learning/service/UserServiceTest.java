package com.shanks.redis.learning.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shanks.redis.learning.domain.User;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class UserServiceTest {
	
	@Autowired
	private UserService userService;
	
	@Test
	public void save() {
		User user = new User();
		user.setMail("cache 111");
		user.setName("123 333");
		user = userService.save(user);
		Assert.assertNotNull(user.getId());
	}
	
	@Test
	public void delete() {
		userService.delete(17l);
	}
}
