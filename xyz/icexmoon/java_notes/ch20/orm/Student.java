package ch20.orm;

@Table("student")
public class Student {
    @ColumnInt(name = "id", pk = true, isUnique = true, isNotNull = true)
    private int id;
    @ColumnStr(name = "name", size = 10, pk = false, isUnique = true, isNotNull = true)
    private String name;
}
