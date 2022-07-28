package com.proglab3.entity;

import com.proglab3.impl.CryableAbout;
import com.proglab3.impl.OnCarlsonPlaceChangedListener;
import com.proglab3.misc.CryVolume;
import com.proglab3.place.Place;
import com.proglab3.place.Room;

import java.util.Objects;

public class Baby extends Entity implements CryableAbout, OnCarlsonPlaceChangedListener {

    private CryVolume cryVolume = CryVolume.QUITE;
    private Carlson carlson;
    private boolean carlsonIsNear;

    public void run(Place place) {
        System.out.print(getName() + " помчался в ");
        if (place.getOwner() == this)
            System.out.println("его " + place.getName());
        else
            System.out.println(place.getName() + " " + place.getOwner().getName());
        setPlace(place);
    }

    public void openWindowInRoom(Room room) {
        room.getWindow().open();
        System.out.println(getName() + " распахнул " + room.getWindow().toString());
    }

    public Entity thinksAbout() {
        if (!carlsonIsNear)
            return carlson;
        return null;
    }

    @Override
    public Entity criesAbout() {
        if (!carlsonIsNear) {
            setCryVolume(CryVolume.QUITE);
            return carlson;
        }

        return null;
    }

    @Override
    public boolean canFly() {
        return false;
    }

    @Override
    public String getName() {
        return "Малыш";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Baby baby = (Baby) o;
        return place.equals(baby.place) && cryVolume.equals(baby.cryVolume)
                && carlson.equals(baby.carlson) && carlsonIsNear == baby.carlsonIsNear;
    }

    public CryVolume getCryVolume() {
        return cryVolume;
    }

    public void setCryVolume(CryVolume cryVolume) {
        this.cryVolume = cryVolume;
    }

    @Override
    public int hashCode() {
        return Objects.hash(place, cryVolume, carlson, carlsonIsNear);
    }

    @Override
    public void onCarlsonPlaceChanged(Carlson carlson, Place place) {
        this.carlson = carlson;
        carlsonIsNear = place != null && place.getOwner() == this;
    }
}
