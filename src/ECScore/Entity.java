package ECScore;

import java.lang.*;
import java.util.concurrent.ConcurrentHashMap;

public class Entity {
    ConcurrentHashMap<Class,IComponentData> componentDataHashMap;

    public ConcurrentHashMap<Class, IComponentData> getComponentDataHashMap() {
        return componentDataHashMap;
    }

    {
        componentDataHashMap=new ConcurrentHashMap<>(10);
    }


}
