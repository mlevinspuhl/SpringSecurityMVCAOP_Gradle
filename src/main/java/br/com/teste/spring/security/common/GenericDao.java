package br.com.teste.spring.security.common;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class GenericDao {
	@PersistenceContext
	protected EntityManager em;
}
