package ch20.orm3;

@Table("student")
public class Student {
    @Column(columnType = ColumnType.INT, name = "id", pk = true, isUnique = true, isNotNull = true)
    private int id;
    @Column(columnType = ColumnType.STRING, name = "name", pk = false, isUnique = false, isNotNull = true, size = 12)
    private String name;
}
