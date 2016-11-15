package com.shanks.redis.learning.repository;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;
import org.springframework.stereotype.Repository;

import com.shanks.redis.learning.domain.User;

@Repository
public class UserRepository {

	@Autowired
	private SqlSessionTemplate template;

	@Cacheable(value = "listUser", key = "#p0 + ''", unless = "#result.size() == 0")
	public List<User> listUser(User user) {
		return template.selectList("com.shanks.redis.learning.repository.UserRepository.listUser", user);
	}

	@Cacheable(value = "user", key="'findById' + #p0", condition = "#result == null")
	public User findById(Long id) {
		return template.selectOne("com.shanks.redis.learning.repository.UserRepository.findById", id);
	}

	@Caching(put = @CachePut(value = "user", key = "'findById' + #p0.id"), evict = @CacheEvict(value = "listUser", allEntries = true))
	public User save(User user) {
		template.insert("com.shanks.redis.learning.repository.UserRepository.save", user);
		return user;
	}

	@Caching(evict = {@CacheEvict(value = "user", allEntries = true), @CacheEvict(value = "listUser", allEntries = true)})
	public void delete(Long id) {
		template.delete("com.shanks.redis.learning.repository.UserRepository.delete", id);
	}
}
