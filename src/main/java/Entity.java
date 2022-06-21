import java.io.Serializable;

public abstract class Entity extends File implements Serializable , Library {
    private String entityName;
    private String entityNationalCode;

    public Entity(String entityName, String entityNationalCode) {
        this.entityName = entityName;
        this.entityNationalCode = entityNationalCode;
    }

    public String getEntityName() {
        return entityName;
    }

    public void setEntityName(String entityName) {
        this.entityName = entityName;
    }

    public String getEntityNationalCode() {
        return entityNationalCode;
    }

    public void setEntityNationalCode(String entityNationalCode) {
        this.entityNationalCode = entityNationalCode;
    }
}
