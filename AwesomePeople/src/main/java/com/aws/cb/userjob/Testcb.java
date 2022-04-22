package com.aws.cb.userjob;

import java.io.Serializable;

import javax.annotation.PostConstruct;

import com.annotations.Conversationally;
import com.aws.cb.main.BaseCB;
import com.ent.user.Person;

@Conversationally
public class Testcb extends BaseCB<Person> implements Serializable {

	private static final long serialVersionUID = 786396253383220511L;

	private boolean hasPerson;

	@Override
	@PostConstruct // init metodunun bean çağrıldığı anda çalıştırılması için tanımlandı.
	public void init() {
		logger.info("testcb initializing");
		if (getCurrentUser() != null && getCurrentUser().getPerson() != null) {
			hasPerson = true;
		} else {
			hasPerson = false;
		}
	}

	public boolean isHasPerson() {
		logger.info(getCurrentUser().getUserName() + "hes no person!");
		return hasPerson;
	}

	public void setHasPerson(boolean hasPerson) {
		this.hasPerson = hasPerson;
	}

}
