package ru.tinkoff.fintech.lesson4.validation;
import ru.tinkoff.fintech.lesson4.model.Student;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import static java.util.Objects.isNull;

public class StudentValidator implements ConstraintValidator<StudentConstraint, Student> {
@Override
    public boolean isValid(Student student, ConstraintValidatorContext constraintValidatorContext) {
    if (isNull(student.getId()) && isNull(student.getName()) && isNull(student.getAge()) &&
            isNull(student.getTimeStart()) && isNull(student.getTimeEnd()) ) {
        return false;
    }
    return true;
    }
}
