package com.datingapp.user.converter;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created on 28.03.2020
 *
 * @author volkanulutas
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface Converter {
    @AliasFor(
            annotation = Component.class
    )
    String value() default "";
}
