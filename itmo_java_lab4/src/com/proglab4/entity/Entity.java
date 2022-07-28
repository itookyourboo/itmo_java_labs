package com.proglab4.entity;

import com.proglab4.place.Place;

public abstract class Entity {
    protected Place place = null;

    public abstract String getName();

    public abstract Sex getSex();

    public boolean canFly() {
        return false;
    }

    public Place getPlace() {
        return place;
    }

    public void setPlace(Place place) {
        this.place = place;
    }

    public static enum Sex {
        MALE, FEMALE
    }
}
