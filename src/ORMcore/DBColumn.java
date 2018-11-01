package ORMcore;

public class DBColumn {
    private String columnName;

    private String dataType;

    private int keyType;        //(0=普通键，1=主键，2=外键)

    DBColumn() {
    }

    DBColumn(String columnName, String dataType, int keyType) {
        this.columnName = columnName;
        this.dataType = dataType;
        this.keyType = keyType;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public int getKeyType() {
        return keyType;
    }

    public void setKeyType(int keyType) {
        this.keyType = keyType;
    }
}
