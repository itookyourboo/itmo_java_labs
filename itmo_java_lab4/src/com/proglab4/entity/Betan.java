package com.proglab4.entity;

import com.proglab4.place.Roof;

import java.util.Objects;

public class Betan extends Entity {
    @Override
    public String getName() {
        return "Бетан";
    }

    @Override
    public Sex getSex() {
        return Sex.FEMALE;
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
        Betan room = (Betan) o;
        return place.equals(room.place);
    }
}
