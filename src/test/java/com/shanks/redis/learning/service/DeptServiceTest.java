package com.shanks.redis.learning.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.shanks.redis.learning.domain.Dept;

@RunWith(value = SpringRunner.class)
@SpringBootTest
public class DeptServiceTest {
	
	@Autowired
	private DeptService deptService;
	
	@Test
	public void save() {
		Dept dept = new Dept();
		dept.setName("123 333");
		deptService.save(dept);
		Assert.assertNotNull(dept.getId());
	}
	
	@Test
	public void delete() {
		deptService.delete(17l);
	}
}
