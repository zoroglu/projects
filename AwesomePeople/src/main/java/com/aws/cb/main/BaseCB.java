package com.aws.cb.main;

import javax.inject.Inject;

import org.slf4j.Logger;

import com.annotations.matching.AweLog;
import com.annotations.matching.LoggedIn;
import com.annotations.matching.TheBaseService;
import com.ent.main.AbstractBaseEntity;
import com.ent.user.User;
import com.mix.svc.main.IBaseService;
/**
 * @author zoroglu resul
 * @author yilmaz ahmet
 * 
 * login ve signup sayfalarının baseCB ile etkileşimi olmamalı bence
 */
public abstract class BaseCB<E extends AbstractBaseEntity> implements GenericBaseCB<E>{
	
	@Inject
	@TheBaseService
	IBaseService baseService;
	
	@Inject
	@LoggedIn  //Login.java nın @loggedIn ile notasyonlandırılmış methodunu kullanarak bu alanı doldur
	private User currentUser;
	
	@Inject 
	@AweLog
	protected Logger logger;

	@Override
	public void save(E entity) {
		baseService.save(entity);
	}
	
	@Override
	public void update(E entity) {
		baseService.update(entity);
	}

	private E instance;
	public abstract void init();

	public E getInstance() {
		return instance;
	}

	public void setInstance(E instance) {
		this.instance = instance;
	}

	public User getCurrentUser() {
		return currentUser;
	}

	public void setCurrentUser(User currentUser) {
		this.currentUser = currentUser;
	}
}
