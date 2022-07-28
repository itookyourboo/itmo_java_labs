package com.proglab3.place;

import com.proglab3.impl.InstanceChecker;

import java.util.Objects;

public class School extends Place implements InstanceChecker {

    private boolean exists = true;

    public void burn() {
        exists = false;
    }

    public void extinguish() {
        exists = true;
    }

    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public void printInstance() {
        System.out.println(exists() ? "Была школа" :
                "Школа сгорела, можно не делать домашку");
    }

    @Override
    public String getName() {
        return "школа";
    }

    @Override
    public String toString() {
        return getName();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        School school = (School) o;
        return exists == school.exists && owner.equals(school.getOwner());
    }

    @Override
    public int hashCode() {
        return Objects.hash(exists, owner);
    }
}
