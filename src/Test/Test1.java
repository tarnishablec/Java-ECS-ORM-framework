package Test;

import Components.Account;
import ECScore.*;

import java.lang.reflect.InvocationTargetException;
import java.sql.SQLException;
import java.util.ArrayList;

public class Test1 {
    public static void main(String[] args) throws InvocationTargetException, NoSuchMethodException, InstantiationException, SQLException, IllegalAccessException, ClassNotFoundException {
        ArrayList<Entity> entities = EntityManager.loadEntity(Account.class);
        for (var e:entities){
            System.out.println(EntityManager.getComponentData(e,Account.class));
        }
    }
}
