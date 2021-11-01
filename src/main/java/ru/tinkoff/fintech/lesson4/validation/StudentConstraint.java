package ru.tinkoff.fintech.lesson4.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Type;

@Constraint(validatedBy = StudentValidator.class)
@Target({ElementType.TYPE, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
public @interface StudentConstraint {
    String message() default "All fields can t be null!";
    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};


}
