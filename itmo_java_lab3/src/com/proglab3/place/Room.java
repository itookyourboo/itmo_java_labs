package com.proglab3.place;

import com.proglab3.misc.Window;
import com.proglab3.entity.Entity;

import java.util.Objects;

public class Room extends Place {

    private Window window;

    public Room() {
        window = new Window();
    }

    public Room(Entity owner) {
        this();
        setOwner(owner);
    }

    public Window getWindow() {
        return window;
    }

    @Override
    public String getName() {
        return "комната";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Room room = (Room) o;
        return window.equals(room.getWindow()) && owner.equals(room.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(window, owner);
    }

    @Override
    public String toString() {
        return getName();
    }
}
