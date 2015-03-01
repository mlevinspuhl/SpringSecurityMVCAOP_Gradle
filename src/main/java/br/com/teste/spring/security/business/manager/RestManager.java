package br.com.teste.spring.security.business.manager;

import java.util.List;

import br.com.teste.spring.security.common.domain.Pet;
import br.com.teste.spring.security.common.domain.User;
import br.com.teste.spring.security.common.exception.CommonException;

public interface RestManager {

	public Pet getPet(Integer idPet)throws CommonException;
	
	public List<User> findAllUsers();
	public List<User> findUsers(String username);
	
}
