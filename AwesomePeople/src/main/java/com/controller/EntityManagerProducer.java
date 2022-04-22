package com.controller;

import java.util.logging.Logger;

import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import com.annotations.matching.AwesomeEM;

public class EntityManagerProducer {

	@Inject
	EntityManagerFactory emf; //Applicationscope da var olan emf yi al.EntityManagerFac deki emf yi kullanıyor
	
	@AwesomeEM
	@Produces
	public EntityManager createEntityManager() {
		return emf.createEntityManager();
	}
	
	public void close(@Disposes @AwesomeEM EntityManager em) {
		if(em.isOpen()) {
			em.clear();
			em.close();
		} else {
			System.out.println(em.toString() + " is already closed");//zaten kapatıldı
		}
	}
}
