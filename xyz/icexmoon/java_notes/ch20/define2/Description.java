package ch20.define2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE)
public @interface Description {
    String autor();

    String date();

    int version() default 1;

    String lastModified();

    String lastModifiedBy();

    String[] reviewer();
}
