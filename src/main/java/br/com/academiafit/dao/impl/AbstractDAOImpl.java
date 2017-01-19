package br.com.academiafit.dao.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class AbstractDAOImpl {
	@PersistenceContext(unitName="jpa-persistence")
	private EntityManager entityManager;

	public EntityManager getEntityManager() {
		return entityManager;
	}

	public void setEntityManager(EntityManager em) {
		this.entityManager = em;
	}

	public String excluir(int index) {
		// TODO Auto-generated method stub
		return null;
	}
}
