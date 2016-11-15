package com.shanks.redis.learning.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class Dept implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private Long id;
	
	private String name;
	
	
}
