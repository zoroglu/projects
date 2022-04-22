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
 * TheBaseDao daki gibi , baseService inject edilmek istendiğinde sadece baseserviceImpl
 * sınıfını inject et diyerek sunucuya tek bir seçim hakkı tanıdığımız için 
 * ambigious inject hatasından kurtarıyoruz
 *
 */
@Qualifier
@Target({ TYPE, METHOD, PARAMETER, FIELD })
@Retention(RUNTIME)
@Documented
public @interface TheBaseService {

}
