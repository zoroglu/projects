package com.app;

import java.io.Serializable;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.annotations.matching.AweLog;

/*
 * Projede her an kullanıma hazır olmak üzere log imkanı sağlandı
 */
public class Loggers implements Serializable {

	@Produces
	@AweLog
	Logger getLogger(InjectionPoint injectionPoint) {
		return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass().getName());
	}
}
// kaynak
// https://stackoverflow.com/questions/36292033/logging-best-approach-with-cdi