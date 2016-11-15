package com.shanks.redis.learning.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.shanks.redis.learning.domain.Dept;
import com.shanks.redis.learning.service.DeptService;

@RestController
public class DeptController {

	@Autowired
	private DeptService deptService;
	
	@RequestMapping(value = "/dept", method = RequestMethod.GET)
	public Object user(Dept dept, @PageableDefault Pageable pageable) {
		return deptService.listDept(dept);
	}
	
	@RequestMapping(value = "/dept/{id}", method = RequestMethod.GET)
	public Object user(@PathVariable Long id) {
		return deptService.findById(id);
	}
	
	@RequestMapping(value = "/dept", method = RequestMethod.POST)
	public Object save(Dept dept) {
		return deptService.save(dept);
	}
	
}
