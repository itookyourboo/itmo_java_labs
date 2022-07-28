package com.proglab4.entity;

import com.proglab4.exceptions.CarlsonIsAngryException;
import com.proglab4.impl.*;
import com.proglab4.misc.CryVolume;
import com.proglab4.place.Place;
import com.proglab4.place.Room;
import com.proglab4.place.Village;

import java.util.Objects;

public class Baby extends Entity implements CryableAbout, OnCarlsonPlaceChangedListener, CareableAbout, Playable, Huggable {

    private CryVolume cryVolume = CryVolume.QUITE;
    private Carlson carlson;
    private boolean carlsonIsNear;
    private Entity playingWith = null;
    private boolean isHappy = true;

    public void run(Place place) {
        if (place == null) throw new IllegalArgumentException("place cannot be null");
        System.out.print(getName() + " помчался в ");
        if (place.getOwner() == this)
            System.out.println("его " + place.getName());
        else
            System.out.println(place.getName() + " " + place.getOwner().getName());
        setPlace(place);
    }

    public void openWindowInRoom(Room room) {
        if (room == null) throw new IllegalArgumentException("room can not be null");
        if (room.getWindow() == null) throw new NullPointerException("room does not have window");
        room.getWindow().open();
        System.out.println(getName() + " распахнул " + room.getWindow().toString());
    }

    public Entity thinksAbout() {
        if (!carlsonIsNear && playingWith == null)
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
    public Entity caresAbout() {
        if (!carlsonIsNear) return carlson;
        return null;
    }

    @Override
    public void play(Entity entity) {
        if (entity == null) throw new IllegalArgumentException("entity can not be null");
        this.playingWith = entity;
        System.out.println(getName() + " играет с " + playingWith.getName());
    }

    @Override
    public void stopPlaying() {
        this.playingWith = null;
    }

    @Override
    public Sex getSex() {
        return Sex.MALE;
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
        if (cryVolume == null) throw new IllegalArgumentException("cryVolume can not be null");
        this.cryVolume = cryVolume;
    }

    public boolean isHappy() {
        return isHappy;
    }

    public void setHappy(boolean happy) {
        isHappy = happy;
        if (isHappy) System.out.println(getName() + " счастлив");
        else System.out.println(getName() + " не счастлив");
    }

    @Override
    public void hug(Entity entity) {
        if (entity == null) throw new IllegalArgumentException("entity can not be null");
        System.out.println(getName() + " обнимает " + entity.getName());
        if (entity instanceof Carlson && ((Carlson) entity).isAngry())
            throw new CarlsonIsAngryException("Карлсон злой!");
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
