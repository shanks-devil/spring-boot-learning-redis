package com.shanks.redis.learning.repository;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.cache.annotation.Caching;

import com.shanks.redis.learning.domain.Dept;

@Mapper
public interface DeptRepsoitory {

	@Cacheable(value = "dept", key = "'listDept' + #p0")
	List<Dept> listDept(Dept dept);

	@Cacheable(value = "dept", key = "'findById' + #p0")
	Dept findById(Long id);

	@Caching(put = @CachePut(value = "dept", key = "'findById' + #p0.id"), evict = @CacheEvict(value = "dept", key = "'listDept'"))
	void save(Dept dept);

	@CacheEvict(value = "dept", key = "'findById' + #p0")
	@Caching(evict = {@CacheEvict(value = "dept", key = "'findById' + #p0"), @CacheEvict(value = "dept", key = "'listDept'")})
	void delete(Long id);
}
