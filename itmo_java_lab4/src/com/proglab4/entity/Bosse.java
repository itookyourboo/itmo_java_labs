package com.proglab4.entity;

import java.util.Objects;

public class Bosse extends Entity {
    @Override
    public String getName() {
        return "Боссе";
    }

    @Override
    public Sex getSex() {
        return Sex.MALE;
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
        Bosse room = (Bosse) o;
        return place.equals(room.place);
    }
}
