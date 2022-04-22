package com.mix.dao.user;

import java.io.Serializable;

import javax.persistence.NoResultException;
import javax.persistence.Query;
import com.ent.user.User;
import com.mix.dao.main.AbstractBaseJpaDao;

public class UserDaoImpl extends AbstractBaseJpaDao<User> implements UserDao, Serializable {

	private static final long serialVersionUID = 1L;

	@Override
	public User getUserByUsernamePassword(String username, String password) {
		try {
			Query query = null;
			if (username != null && password != null) {
				query = getEntityManager().createQuery("from User U where U.userName=:uname and password=:pass");
				query.setParameter("uname", username).setParameter("pass", password).getSingleResult();
			}
			if (username != null && password == null) {
				query = getEntityManager().createQuery("from User U where U.userName=:uname");
				query.setParameter("uname", username).getSingleResult();
			}
			User user = (User) query.getSingleResult();

			/*
			 * EntityManager ile ilişkilendirilmiş olan tüm nesnelerin ilişkisini koparır.
			 * Böylece Nesnenin bağını koparıp durumlarındaki değişiklikleri EntityManager
			 * takip etmez. Eğer bunu yazmazsak daha önce bu metodu kullandığımız verileri
			 * getirir.
			 */
			getEntityManager().clear();
			return user;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	public User getUserByUsernameHashCode(String username, String hashCode) {
		try {
			Query query = null;
			if (username != null && hashCode != null) {
				query = getEntityManager()
						.createQuery("from User U where U.userName=:uname and U.activationHash=:hashCode");
				query.setParameter("uname", username).setParameter("hashCode", hashCode);
			}
			User user = (User) query.getSingleResult();
			getEntityManager().clear();
			return user;

		} catch (NoResultException e) {
			return null;
		}
	}
}