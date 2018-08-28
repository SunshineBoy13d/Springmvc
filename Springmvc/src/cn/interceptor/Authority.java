package cn.interceptor;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD,ElementType.TYPE})
@Documented
public @interface Authority {
AuthorityType value() default AuthorityType.Validate;
}
