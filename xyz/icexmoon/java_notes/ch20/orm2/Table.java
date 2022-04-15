package ch20.orm2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value() default "";
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnCommon {
    String name() default "";

    boolean pk() default false;

    boolean isUnique() default false;

    boolean isNotNull() default true;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnInt {
    ColumnCommon common() default @ColumnCommon;
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface ColumnStr {
    ColumnCommon common() default @ColumnCommon;

    int size();
}
