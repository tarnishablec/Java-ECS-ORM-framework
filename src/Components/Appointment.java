package Components;

import ECScore.IComponentData;

import java.sql.Timestamp;

public class Appointment implements IComponentData {
    public Integer recordId;
    public String item;
    public String inspect;
    public String supply;
    public Timestamp creatAt;
}
