package com.proglab3.misc;

import java.util.Objects;

public class Window {
    private boolean isOpened = false;

    public boolean isOpened() {
        System.out.printf("Окно %s", isOpened ? "открыто" : "закрыто");
        System.out.println();
        return isOpened;
    }

    public void open() {
        isOpened = true;
    }

    public void close() {
        isOpened = false;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Window window = (Window) o;
        return isOpened == window.isOpened;
    }

    @Override
    public int hashCode() {
        return Objects.hash(isOpened);
    }

    @Override
    public String toString() {
        return "окно";
    }
}
