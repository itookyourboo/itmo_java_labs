package com.proglab3.entity;

import com.proglab3.impl.InstanceChecker;
import com.proglab3.impl.OnCarlsonPlaceChangedListener;
import com.proglab3.place.Place;
import com.proglab3.place.Roof;

import java.util.Objects;

public class Carlson extends Entity implements InstanceChecker {

    private OnCarlsonPlaceChangedListener onPlaceChanged;
    private Baby baby;

    public void setBaby(Baby baby) {
        this.baby = baby;
    }

    public Baby getBaby() {
        return baby;
    }

    public void setOnPlaceChangedListener(OnCarlsonPlaceChangedListener onPlaceChanged) {
        this.onPlaceChanged = onPlaceChanged;
    }

    @Override
    public void setPlace(Place place) {
        super.setPlace(place);
        if (onPlaceChanged != null)
            onPlaceChanged.onCarlsonPlaceChanged(this, place);
    }

    @Override
    public boolean canFly() {
        return true;
    }

    private boolean isOnBabysRoof(){
        return getPlace() instanceof Roof && getPlace().getOwner() == getBaby();
    }

    @Override
    public boolean exists() {
        return isOnBabysRoof();
    }

    @Override
    public void printInstance() {
        if (exists())
            System.out.println("Карлсон есть!");
        else
            System.out.println("Карлсона не было и не было...");
    }

    @Override
    public String getName() {
        return "Карлсон";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carlson carlson = (Carlson) o;
        return place.equals(carlson.place) && baby.equals(carlson.baby);
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, baby);
    }
}
