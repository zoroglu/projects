package com.aws.cb.main;

import com.ent.main.AbstractBaseEntity;
import com.ent.main.BaseEntity;

/**
 * @author zoroglu resul
 * @author yilmaz ahmet
 */
public interface GenericBaseCB<E extends AbstractBaseEntity> {
	public E getInstance();
	public void init();
	public void save(E entity);
	public void update(E entity);
}
