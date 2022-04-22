package com.annotations.matching;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.inject.Qualifier;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.ElementType.PARAMETER;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

/**
 * 
 * @author TheCio
 * tüm daoImpl sınıfları basedao interface sini implement etmiş oluyor dolaylı yoldan.
 * Bu durumda herhangi bir entity e bağlı olmayan bir dao service ihtiyacında,
 * server injectionpoint ararken karşısında tüm entity lerin daoimpl sınıfları ile karşılaşıp
 * hangisinin inject edileceğini anlamayıp ambigious inject hatası verir.
 * bu durumda sadece baseservice inject edildiğindi, bana sadece basedaoImpl sınıfı inject et  diyerek
 * sunucuya sadece tek bir seçenek bırakıyoruz.
 *
 */
@Qualifier
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface TheBaseDao {

}
