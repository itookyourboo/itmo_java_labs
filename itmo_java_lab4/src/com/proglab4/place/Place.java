package com.proglab4.place;

import com.proglab4.entity.Entity;

public abstract class Place {
    protected Entity owner;

    public Entity getOwner() {
        return owner;
    }

    public void setOwner(Entity owner) {
        this.owner = owner;
    }

    public abstract String getName();
}
