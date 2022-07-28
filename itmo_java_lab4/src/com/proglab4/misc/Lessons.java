package com.proglab4.misc;

import com.proglab4.impl.InstanceChecker;

import java.util.Objects;

public class Lessons implements InstanceChecker {

    private boolean exists = true;

    public void cancel() {
        exists = false;
    }

    public void set() {
        exists = true;
    }

    @Override
    public boolean exists() {
        return exists;
    }

    @Override
    public void printInstance() {
        System.out.println(exists() ? "Были уроки" :
                "Уроков не было! Теперь малыш мог плакать целый день!");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Lessons lessons = (Lessons) o;
        return exists == lessons.exists;
    }

    @Override
    public int hashCode() {
        return Objects.hash(exists);
    }

    @Override
    public String toString() {
        return "уроки";
    }
}
