package Components;


import ECScore.FieldAnnotation;
import ECScore.IComponentData;

public class Account implements IComponentData {
    @FieldAnnotation(columnName = "id",type = "int",priKey = 1)
    public Integer id;
    @FieldAnnotation(columnName = "password",type = "varchar")
    public String password;
    @FieldAnnotation(columnName = "name",type = "varchar")
    public String name;
    @FieldAnnotation(columnName = "phone",type = "int")
    public Integer phone;
    @FieldAnnotation(columnName = "email",type = "varchar")
    public String email;
    @FieldAnnotation(columnName = "age",type = "int")
    public Integer age;
    @FieldAnnotation(columnName = "sex",type = "varchar")
    public String sex;
}
