package com.taskOrganizerApp.vallidation;

import com.taskOrganizerApp.model.annotation.DateInFuture;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;

public class DateInFutureValidator
        implements ConstraintValidator<DateInFuture,String> {
    @Override
    public boolean isValid(String value,
                           ConstraintValidatorContext context) {
        if (value!=null && !value.isBlank()){
            LocalDate parse = LocalDate.parse(value);
            return parse.isAfter(LocalDate.now());
        }

        return false;
    }

    @Override
    public void initialize(DateInFuture constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }
}
