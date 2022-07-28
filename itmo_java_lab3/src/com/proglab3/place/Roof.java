package com.proglab3.place;

import com.proglab3.entity.Entity;

import java.util.Objects;

public class Roof extends Place {

    public Roof() {}

    public Roof(Entity entity) {
        this();
        setOwner(entity);
    }

    @Override
    public String getName() {
        return "крыша";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roof room = (Roof) o;
        return owner.equals(room.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }
}
