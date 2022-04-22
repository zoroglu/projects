package com.mix.svc.main;

import javax.inject.Inject;

import com.annotations.matching.TheBaseDao;
import com.ent.main.AbstractBaseEntity;
import com.ent.main.BaseEntity;
import com.mix.dao.main.IBaseDao;

public abstract class AbstractBaseService<E extends AbstractBaseEntity> implements IBaseService<E>{

	@Inject
	@TheBaseDao
	IBaseDao baseDaoService;

	@Override
	public void save(AbstractBaseEntity entity) {
		baseDaoService.save(entity);
	}
	
	@Override
	public void update(AbstractBaseEntity entity) {
		baseDaoService.update(entity);
	}
		
}
