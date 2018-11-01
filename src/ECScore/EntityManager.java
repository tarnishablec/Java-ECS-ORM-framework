package ECScore;

import MyUtils.JavaFileUtils;
import ORMcore.DBManager;
import ORMcore.DBMapper;
import ORMcore.DBTable;
import ORMcore.MysqlTypeConvertor;
import com.sun.source.tree.TryTree;

import java.lang.reflect.*;
import java.sql.*;
import java.util.*;

public class EntityManager {

    public static ArrayList<Entity> entityPool;

    static {
        entityPool=new ArrayList<>(10);
    }

    public static void init(){
        Map<String,DBTable> map=DBMapper.tables;
        for (var t:map.values()){
            JavaFileUtils.createJavaFile(t,new MysqlTypeConvertor());
        }
    }

    private static class EntityManagerInstance{
        private static final EntityManager instance = new EntityManager();
    }

    public static EntityManager getOrCreateManager(){
        return EntityManagerInstance.instance;
    }

    public static void addComponent(Entity entity, IComponentData...componentDatas){
        for (IComponentData componentData:componentDatas){
            entity.componentDataHashMap.put(componentData.getClass(),componentData);
        }
    }

    public static void removeComponent(Entity entity, Class componentType){
        entity.componentDataHashMap.remove(componentType);
    }

    private static Entity createEntity(IComponentData... componentDatas){
        Entity entity = new Entity();
        for (IComponentData componentData : componentDatas) {
            entity.componentDataHashMap.put(componentData.getClass(), componentData);
        }
        entityPool.add(entity);
        return entity;
    }


    public static Entity createEntity(EntityArchetype entityArchetype) throws NoSuchMethodException, IllegalAccessException, InstantiationException, InvocationTargetException {
        Entity entity = new Entity();
        for (Class tClass:entityArchetype.getComponentDataClasses()){
            Constructor cons=tClass.getConstructor();
            cons.setAccessible(true);
            entity.componentDataHashMap.put(tClass,(IComponentData)cons.newInstance());
        }
        entityPool.add(entity);
        return entity;
    }

    private static EntityArchetype createArchetype(Class... classes){

        for (Class c:classes){
            if (!IComponentData.class.isAssignableFrom(c)){
                throw new NullPointerException();
            }
        }
        EntityArchetype ea= new EntityArchetype();
        ea.setComponentDataClasses(classes);
        return ea;
    }

    public <T extends IComponentData> void setComponentData(Entity entity, T t){
        if (!entityPool.contains(entity)){
            throw new NullPointerException();
        }else{
            if (entity.componentDataHashMap.containsKey(t.getClass())){
                entity.componentDataHashMap.replace(t.getClass(),t);
            }else {
                throw new NullPointerException();
            }
        }
    }

    public static  <T extends IComponentData> T getComponentData(Entity entity,Class<T> tClass){
        IComponentData icd;
        icd=entity.componentDataHashMap.getOrDefault(tClass,null);
        return (T)icd;
    }

    public void removeEntity(Entity entity){
        entityPool.remove(entity);
    }

    public static ArrayList<Entity> loadEntity(Class clazz){
        ArrayList<Entity> entityList= new ArrayList<>();
        try {
            Connection conn = DBManager.createConn();
            for (DBTable t:DBMapper.tables.values()){
                if (t.getTableName().equalsIgnoreCase(clazz.getSimpleName())){
                    String sql="select * from "+t.getTableName();
                    assert conn != null;
                    ResultSet rs = conn.prepareStatement(sql).executeQuery();

                    Field[] fields=clazz.getFields();
                    IComponentData iComponent = null;
                    while (rs.next()){
                        iComponent = (IComponentData) clazz.getConstructor().newInstance();
                        for (Field f:fields){
                            f.set(iComponent,rs.getObject(f.getName()));
                        }
                        Entity entity = EntityManager.createEntity(iComponent);
                        entityList.add(entity);
                    }
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return entityList;
    }

}
