package com.datingapp.game.converter;

import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * Created on 27.03.2020
 *
 * @author onurcanyozgat
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