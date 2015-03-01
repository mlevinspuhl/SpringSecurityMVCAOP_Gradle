package br.com.teste.spring.security.business.manager;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import br.com.teste.spring.security.business.dao.RestDao;
import br.com.teste.spring.security.common.domain.Pet;
import br.com.teste.spring.security.common.domain.User;
import br.com.teste.spring.security.common.exception.CommonException;

@Component(value = "restManager")
public class RestManagerImpl implements RestManager {

	@Autowired
	RestDao dao;

	@Override
	public Pet getPet(Integer idPet) throws CommonException {

		Pet pet = new Pet();

		switch (idPet) {
		case 0:
			pet.setName("Kiko");
			break;
		case 1:
			pet.setName("Willy");
			break;
		default:
			throw new CommonException("No pet found!");
		}
		pet.setIdPet(idPet);
		return pet;
	}

	@Override
	public List<User> findAllUsers() {

		return dao.findAllUsers();
	}

	@Override
	public List<User> findUsers(String username) {
		List<User> users = null;
		if (username != null && !username.isEmpty()) {
			users = new ArrayList<>();
			User user = dao.findUser(username);
			if (user != null) {
				users.add(dao.findUser(username));
			}

		} else {
			users = dao.findAllUsers();
		}

		return users;

	}

}
