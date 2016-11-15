package com.shanks.redis.learning.domain;

import java.io.Serializable;

import lombok.Data;

@Data
public class User implements Serializable {

	private static final long serialVersionUID = 1416246045128588039L;

	private Long id;
	
	private String name;
	
	private String mail;
	
}
