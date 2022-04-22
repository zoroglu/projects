package com.mix.dao.main;

import com.ent.main.AbstractBaseEntity;
import com.ent.main.BaseEntity;

public interface IBaseDao<E extends AbstractBaseEntity>{

	void save(E entity);
	void update(E entity);
}
