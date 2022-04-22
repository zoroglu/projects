package com.mix.svc.user;

import java.io.Serializable;

import com.ent.user.Person;
import com.mix.svc.main.AbstractBaseService;

public class PersonServiceImpl extends AbstractBaseService<Person> implements PersonService,Serializable{

	private static final long serialVersionUID = 4534748577713371784L;
}
