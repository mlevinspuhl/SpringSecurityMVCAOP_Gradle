package br.com.teste.spring.security.business.dao;

import java.util.List;

import br.com.teste.spring.security.common.domain.User;
import br.com.teste.spring.security.common.exception.CommonException;

public interface RestDao {
	
	public List<User> findAllUsers();
	public User findUser(String username);

}
