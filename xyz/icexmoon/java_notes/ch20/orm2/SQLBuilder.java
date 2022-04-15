package ch20.orm2;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SQLBuilder {
    public static void main(String[] args) {
        List<Class<?>> allCls = new ArrayList<>();
        allCls.addAll(Arrays.asList(Student.class));
        StringBuilder SQLsb = new StringBuilder();
        for (Class<?> cls : allCls) {
            Table table = cls.getAnnotation(Table.class);
            if (table != null) {
                String tableName = table.value();
                if (tableName.length() == 0) {
                    tableName = cls.getSimpleName().toLowerCase();
                }
                SQLsb.append("CREATE TABLE `test`.`");
                SQLsb.append(tableName);
                SQLsb.append("`(");
                String primaryKey = "";
                for (Field field : cls.getDeclaredFields()) {
                    Annotation[] annotations = field.getDeclaredAnnotations();
                    if (annotations.length != 0) {
                        for (Annotation annotation : annotations) {
                            if (annotation != null) {
                                if (annotation instanceof ColumnInt) {
                                    ColumnInt columnInt = (ColumnInt) annotation;
                                    SQLsb.append(columnIntSQL(columnInt));
                                    SQLsb.append(",");
                                    if (columnInt.common().pk()) {
                                        primaryKey = columnInt.common().name();
                                    }
                                } else if (annotation instanceof ColumnStr) {
                                    ColumnStr columnStr = (ColumnStr) annotation;
                                    SQLsb.append(columnStrSQL(columnStr));
                                    SQLsb.append(",");
                                    if (columnStr.common().pk()) {
                                        primaryKey = columnStr.common().name();
                                    }
                                } else {
                                    ;
                                }
                            }
                        }
                    }
                }
                SQLsb.append(" PRIMARY KEY (`");
                SQLsb.append(primaryKey);
                SQLsb.append("`) );");
            }

        }
        System.out.println(SQLsb.toString());
    }

    private static String columnStrSQL(ColumnStr columnStr) {
        StringBuilder sb = new StringBuilder();
        sb.append(" `");
        sb.append(columnStr.common().name());
        sb.append("` VARCHAR(");
        int size = columnStr.size();
        if (size < 0) {
            size = 10;
        }
        sb.append(size);
        sb.append(")");
        if (columnStr.common().isNotNull()) {
            sb.append(" NOT NULL");
        }
        return sb.toString();
    }

    private static String columnIntSQL(ColumnInt columnInt) {
        StringBuilder sb = new StringBuilder();
        sb.append(" `");
        sb.append(columnInt.common().name());
        sb.append("` INT UNSIGNED");
        if (columnInt.common().isNotNull()) {
            sb.append(" NOT NULL");
        }
        return sb.toString();
    }
}
// CREATE TABLE `test`.`student`( `id` INT UNSIGNED NOT NULL, `name` VARCHAR(10)
// NOT NULL, PRIMARY KEY (`id`) );