package cn.interceptor;


import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(value = {ElementType.METHOD})
@Documented
public @interface DataSoure {
DataSoureType value() default  DataSoureType.Master;
}
