package model;

import java.io.Serializable;

public abstract class StorableEntity<ID> implements Serializable {
    private static final long serialVersionUID = 11111111;

    private ID id;
    public StorableEntity() {};
    public StorableEntity(ID id) {
        this.id = id;
    }

    public ID getId() {
        return id;
    }

}
