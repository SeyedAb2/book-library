import java.io.Serializable;

public abstract class Entity extends JavaSQL implements Serializable , Library {
    private String entityName;
    private int entityNationalCode;

    public Entity(String entityName, int entityNationalCode) {
        this.entityName = entityName;
        this.entityNationalCode = entityNationalCode;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public int getEntityNationalCode() {
        return entityNationalCode;
    }

    public void setEntityNationalCode(int entityNationalCode) {
        this.entityNationalCode = entityNationalCode;
    }
}
