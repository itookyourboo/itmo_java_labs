package com.proglab4.place;

import com.proglab4.entity.Entity;

import java.util.Objects;

public class Village extends Place {
    @Override
    public String getName() {
        return "Деревня";
    }

    @Override
    public String toString() {
        return String.format("%s{owner: %s}", getName(), getOwner().getName());
    }

    public class Redneck extends Entity {

        {
            setPlace(Village.this);
        }

        @Override
        public String getName() {
            return "Деревенщина";
        }

        @Override
        public Sex getSex() {
            return null;
        }

        @Override
        public String toString() {
            return getName();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Village room = (Village) o;
        return owner.equals(room.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }
}
