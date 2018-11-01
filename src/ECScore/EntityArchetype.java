package ECScore;

public class EntityArchetype implements IEquatable<EntityArchetype>{
    private Class[] componentDataClasses;

    @Override
    public boolean equalsTo(EntityArchetype entityArchetype) {
        int hashSum=0;
        for (Class c:componentDataClasses){
            hashSum +=c.hashCode();
        }
        for (Class cc:entityArchetype.componentDataClasses){
            hashSum -=cc.hashCode();
        }
        return hashSum == 0;
    }

    void setComponentDataClasses(Class[] componentDataClasses) {
        this.componentDataClasses = componentDataClasses;
    }

    Class[] getComponentDataClasses() {
        return componentDataClasses;
    }
}
