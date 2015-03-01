package br.com.teste.spring.security.business.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityGraph;
import javax.persistence.Subgraph;
import javax.persistence.TypedQuery;

import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import br.com.teste.spring.security.common.GenericDao;
import br.com.teste.spring.security.common.domain.User;
import br.com.teste.spring.security.common.domain.UserRole;

@Component(value = "restDao")
public class RestDaoImpl extends GenericDao implements RestDao {

	@Override
	@Transactional
	public List<User> findAllUsers() {
		EntityGraph<User> graph = this.em.createEntityGraph(User.class);
		Subgraph<UserRole> itemGraph = graph.addSubgraph("userRoles");
//		itemGraph.addAttributeNodes("product");

//		Map<String, Object> hints = new HashMap<String, Object>();
//		hints.put("javax.persistence.loadgraph", graph);
		TypedQuery<User> query = em.createQuery("select u from User u", User.class)
				.setHint("javax.persistence.loadgraph", graph);
				
		
		List<User> users = query.getResultList();

				
		return users;
	}

	@Override
	public User findUser(String username) {
		EntityGraph<User> graph = this.em.createEntityGraph(User.class);
		Subgraph<UserRole> itemGraph = graph.addSubgraph("userRoles");
		Map<String, Object> hints = new HashMap<String, Object>();
		hints.put("javax.persistence.loadgraph", graph);
		return em.find(User.class, username, hints);
	}
	
	

}
