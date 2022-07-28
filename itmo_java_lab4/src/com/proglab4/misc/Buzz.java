package com.proglab4.misc;

import com.proglab4.impl.Buzzable;

import java.util.Objects;

public class Buzz {
    private float volume;
    private float wavelength;
    private Buzzable source;

    public Buzz() {
    }

    public Buzz(float volume, float wavelength) {
        setVolume(volume);
        setWavelength(wavelength);
    }

    public float getVolume() {
        return volume;
    }

    public void setVolume(float volume) {
        if (volume < 0 || volume > 1) throw new IllegalArgumentException("Illegal volume value. 0 <= volume <= 1");
        this.volume = volume;
    }

    public float getWavelength() {
        return wavelength;
    }

    public void setWavelength(float wavelength) {
        if (wavelength < 0) throw new IllegalArgumentException("waveLength can not be negative");
        this.wavelength = wavelength;
    }

    public boolean isSimilar(Buzz buzz) {
        if (buzz == null) throw new IllegalArgumentException("buzz can not be null");
        return Math.abs(getVolume() - buzz.getVolume()) < .1f
                && Math.abs(getWavelength() - buzz.getWavelength()) < 1f;
    }

    public Buzzable getSource() {
        return source;
    }

    public void setSource(Buzzable source) {
        this.source = source;
    }

    @Override
    public String toString() {
        if (source != null)
            return "Жужжание{source: " + source.toString() + "}";
        return "Жужжание";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Buzz buzz = (Buzz) o;
        return Float.compare(buzz.volume, volume) == 0 &&
                Float.compare(buzz.wavelength, wavelength) == 0 &&
                Objects.equals(source, buzz.source);
    }

    @Override
    public int hashCode() {
        return Objects.hash(volume, wavelength, source);
    }
}
