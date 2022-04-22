package com.annotations;

import javax.enterprise.context.ConversationScoped;
import javax.enterprise.inject.Stereotype;
import javax.inject.Named;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 *  Bu notasyon(annotation) Bean lerin başına @Named ve @ConversationScope yazmak yerine,her iki notasyonu tek bir notasyon olarak kullanmamızı sağlar.
 */
@Named
@ConversationScoped
@Stereotype
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.FIELD, ElementType.METHOD, ElementType.TYPE })
public @interface Conversationally {
}
