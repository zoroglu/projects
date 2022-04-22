package com.mix.dao.main;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.annotations.matching.AwesomeEM;
import com.ent.main.AbstractBaseEntity;
import com.ent.main.BaseEntity;

public abstract class AbstractBaseJpaDao<E extends AbstractBaseEntity> implements IBaseDao {

	@Inject
	@AwesomeEM
	private EntityManager entityManager;
	
	@Override
	public void save(AbstractBaseEntity entity) {
		entityManager.getTransaction().begin();
		entityManager.persist(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}
	
	@Override
	public void update(AbstractBaseEntity entity) {
		entityManager.getTransaction().begin();
		entityManager.merge(entity);
		entityManager.getTransaction().commit();
		entityManager.close();
	}

	/**
	 * Entitylerin Dao katmanlarının ortak olarak ulaşması için eklendi.
	 */
	public EntityManager getEntityManager() {
		return entityManager;
	}

}
