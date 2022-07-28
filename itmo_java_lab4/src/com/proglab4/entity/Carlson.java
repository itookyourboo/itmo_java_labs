package com.proglab4.entity;

import com.proglab4.impl.*;
import com.proglab4.misc.Buzz;
import com.proglab4.place.Place;
import com.proglab4.place.Roof;

import java.util.Objects;

public class Carlson extends Entity implements InstanceChecker, Kickable {

    private OnCarlsonPlaceChangedListener onPlaceChanged;
    private Baby baby;
    private Motor motor;
    private boolean isFlying = true;

    {
        motor = new Motor();
    }

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

    private boolean isOnBabysRoof() {
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
    public Sex getSex() {
        return Sex.MALE;
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

    public boolean isFlying() {
        return isFlying;
    }

    public void setFlying(boolean flying) {
        isFlying = flying;
        if (flying) System.out.println(getName() + " взлетает");
        else System.out.println(getName() + " приземляется");
    }

    public Motor getMotor() {
        return motor;
    }

    public void clickButton() {
        System.out.println(getName() + " нажимает кнопку");
        motor.setWorking(!motor.isWorking());
    }

    public boolean isAngry() {
        return Math.random() > 0.5;
    }

    @Override
    public void kick(Entity entity) {
        if (entity == null) throw new IllegalArgumentException("entity can not be null");
        System.out.println(getName() + " отпихивает " + entity.getName());
        if (entity instanceof Baby)
            ((Baby) entity).setHappy(false);
    }

    public class Motor implements Buzzable {
        private final Buzz silence = new Buzz(0, 0);
        private final Buzz buzz = new Buzz(.6f, 12f);

        private boolean isWorking = false;

        @Override
        public Buzz getBuzz() {
            if (isWorking) return buzz;
            return silence;
        }

        public boolean isWorking() {
            return isWorking;
        }

        public void setWorking(boolean working) {
            isWorking = working;
            System.out.println("Мотор " + (isWorking ? "включен" : "выключен"));
        }

        @Override
        public String toString() {
            return "Motor{" +
                    "owner=" + Carlson.this.toString() + '}';
        }
    }
}
