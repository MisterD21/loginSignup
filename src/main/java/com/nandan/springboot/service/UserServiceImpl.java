package com.nandan.springboot.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.nandan.springboot.model.User;
import com.nandan.springboot.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepository urepo;
	
	@Override
	public User saveUser(User user) {
		User save = urepo.save(user);
		return save;
	}
}
