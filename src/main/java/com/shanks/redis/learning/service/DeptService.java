package com.shanks.redis.learning.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.shanks.redis.learning.domain.Dept;
import com.shanks.redis.learning.repository.DeptRepsoitory;

@Service
public class DeptService {
	
	@Autowired
	private DeptRepsoitory deptRepsoitory;
	
	public List<Dept> listDept(Dept dept) {
		return deptRepsoitory.listDept(dept);
	}
	
	public Dept findById(Long id) {
		return deptRepsoitory.findById(id);
	}
	
	@Transactional(rollbackFor = Exception.class)
	public Dept save(Dept dept) {
		deptRepsoitory.save(dept);
		return dept;
	}
	
	@Transactional(rollbackFor = Exception.class)
	public void delete(Long id) {
		deptRepsoitory.delete(id);
	}
}
