package com.app;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Disposes;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;

import com.controller.EntityManagerFac;

//Bu Class üzerinde konuşalım mutlaka. olması gereken en mantıklı çözüm naısl olmalı diye.
//@ApplicationScoped Yanlış anlamadıysam buranın appScope olmasının aslında pek bi anlamı yok. araştırılmalı
@ApplicationScoped //Anladıktan sonra yine gerekirse AppScopeYaparız
public class ApplicationStart {
	
	//şimdilik bu scopu kapatıyoruz.Artık entity manager konusuna son verelim :)
	
	
	
	// FIXME bir sıkıntı var. ilk db işleminden sonra entitymanager kapatılıyor. ve
	// açılmıyor.Bu yüzden sayfa patlıyo.

	// @Produces //@Produces: Bu notasyon, global değişkeni veya metod içerisinden
	// dönen değerleri CDI Conteyner tarafından enjekte edilmesini sağlar.
	// @PersistenceContext
	// EntityManager em; //=
	// EntityManagerFac.getEntityManagerFactory().createEntityManager();

	//yukarıda ki kod yeni bir entitymanager üretilmesini engelliyordu.ihtiyac anında zaten var olan entitymanager
	//objesini veriyordu, fakat biz onu kapattığımız için(kapatılması gerekli olduğunu biliyorum) yeni bir sql transaction yapamıyorduk
	//bu method ile ihtiyac anında yeni bir entitymanager objemiz oluyor
	//signupPage i acıp sayfayı yenileyince entitymanager objesinin farklı oldugunu farkedebilirsin emaile test amaçlı koydum
	//	@Produces
	//	public EntityManager entityManager() {
	//		EntityManagerFactory entityManagerFactory = EntityManagerFac.getEntityManagerFactory();
	//		EntityManager em = EntityManagerFac.getEntityManagerFactory().createEntityManager();
	//		return em;
	//	}
	
	
//	@Produces
//	@Dependent
//	EntityManager em = EntityManagerFac.getEntityManagerFactory().createEntityManager();
//	
	//oluşturulan entitymanager açık ise kapat onu

}
