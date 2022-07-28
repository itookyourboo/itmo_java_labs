package com.proglab4.entity;

import java.util.Objects;

public class Bimbo extends Entity {
    @Override
    public String getName() {
        return "Бимбо";
    }

    @Override
    public Entity.Sex getSex() {
        return Entity.Sex.MALE;
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(place);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bimbo room = (Bimbo) o;
        return place.equals(room.place);
    }
}
