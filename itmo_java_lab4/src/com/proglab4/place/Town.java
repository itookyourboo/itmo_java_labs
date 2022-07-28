package com.proglab4.place;

import java.util.Objects;

public class Town extends Place {
    @Override
    public String getName() {
        return "Город";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Town room = (Town) o;
        return owner.equals(room.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(owner);
    }
}
