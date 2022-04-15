package ch20.orm3;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Table {
    String value() default "";
}

enum ColumnType {
    INT, STRING
}

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@interface Column {
    String name() default "";

    boolean pk() default false;

    boolean isUnique() default false;

    boolean isNotNull() default true;

    int size() default -1;

    ColumnType columnType();
}
