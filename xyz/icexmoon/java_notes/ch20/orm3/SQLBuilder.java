package ch20.orm3;

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
                                if (annotation instanceof Column) {
                                    Column column = (Column) annotation;
                                    SQLsb.append(columnSQL(column));
                                    SQLsb.append(",");
                                    if (column.pk()) {
                                        primaryKey = column.name();
                                    }
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

    private static String columnSQL(Column column) {
        StringBuilder sb = new StringBuilder();
        sb.append(" `");
        sb.append(column.name());
        switch (column.columnType()) {
            case STRING:
                sb.append("` VARCHAR(");
                sb.append(column.size());
                sb.append(")");
                break;
            case INT:
                sb.append("` INT UNSIGNED");
                break;
            default:
        }
        if (column.isNotNull()) {
            sb.append(" NOT NULL");
        }
        return sb.toString();
    }

    // private static String columnIntSQL(ColumnInt columnInt) {
    // StringBuilder sb = new StringBuilder();
    // sb.append(" `");
    // sb.append(columnInt.common().name());
    // sb.append("` INT UNSIGNED");
    // if (columnInt.common().isNotNull()) {
    // sb.append(" NOT NULL");
    // }
    // return sb.toString();
    // }
}
// CREATE TABLE `test`.`student`( `id` INT UNSIGNED NOT NULL, `name` VARCHAR(10)
// NOT NULL, PRIMARY KEY (`id`) );