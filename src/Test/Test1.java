package Test;

import Components.Account;
import Components.Appointment;
import ECScore.Entity;
import ECScore.EntityManager;

import java.util.ArrayList;

public class Test1 {

    public static void main(String[] args) {
        EntityManager.init();

        ArrayList<Entity> entities= EntityManager.loadEntity(Account.class);
        System.out.println(EntityManager.entityPool.size());

        for (var e:entities){
            System.out.println(EntityManager.getComponentData(e,Account.class).id);
        }


    }
}
