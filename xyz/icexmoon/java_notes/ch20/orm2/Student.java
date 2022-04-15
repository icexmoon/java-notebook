package ch20.orm2;

@Table("student")
public class Student {
    @ColumnInt(common = @ColumnCommon(name = "id", pk = true, isUnique = true, isNotNull = true))
    private int id;
    @ColumnStr(size = 10, common = @ColumnCommon(name = "name", pk = false, isUnique = true, isNotNull = true))
    private String name;
}
