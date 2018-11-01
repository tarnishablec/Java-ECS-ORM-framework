package ECScore;

        import java.lang.*;
        import java.lang.reflect.Field;
        import java.util.concurrent.ConcurrentHashMap;

public class Entity {
    ConcurrentHashMap<Class,IComponentData> componentDataHashMap;

    public ConcurrentHashMap<Class, IComponentData> getComponentDataHashMap() {
        return componentDataHashMap;
    }

    {
        componentDataHashMap=new ConcurrentHashMap<>(10);
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        for (IComponentData data: this.componentDataHashMap.values()){
            for (Field f:data.getClass().getFields()){
                try {
                    sb.append(f.get(data));
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }
        return  sb.toString();
    }
}
