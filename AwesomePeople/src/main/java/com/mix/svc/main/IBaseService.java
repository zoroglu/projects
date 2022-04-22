package com.mix.svc.main;

import com.ent.main.AbstractBaseEntity;
import com.ent.main.BaseEntity;

public interface IBaseService<E extends AbstractBaseEntity>{
	public void save(E entity);
	public void update(E entity);
}
