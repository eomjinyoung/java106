package bitcamp.java106.pms.annotation;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention(RetentionPolicy.RUNTIME)
public @interface Component {
    String value() default "";
}

//ver 23 - 애노테이션 정의