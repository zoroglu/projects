package com.controller;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped // bu burada olmasa her defasında yeniden oluşacaktı
public class EntityManagerFac implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("awesome");  // <persistence-unit name="awesome" transaction-type="RESOURCE_LOCAL">
	
	@Produces  //appScope da var olan emf yi ver ihtiyaç anında
	public static EntityManagerFactory getEntityManagerFactory() {
		return emf;
	}


}
