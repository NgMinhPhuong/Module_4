package com.example.testanotation.annotation;



import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = NameValidator.class)
//Nếu muốn tạo annotation cho class thì dùng type
//Tạo annotation cho thuộc tính thì dùng field
//Tạo annotation cho phương thức thì dùng method
@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {
    String message() default "Tên không đúng định dạng";
    Class<?> [] groups() default {};
    Class<? extends Payload> [] payload() default {};
}
