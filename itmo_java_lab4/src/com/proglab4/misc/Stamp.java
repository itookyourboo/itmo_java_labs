package com.proglab4.misc;

import java.util.Objects;

public class Stamp {
    private String country;
    private String image;
    private boolean isBeautiful = false;

    public Stamp() {
    }

    public Stamp(String country, String image) {
        setCountry(country);
        setImage(image);
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public boolean isBeautiful() {
        return isBeautiful;
    }

    public void setBeautiful(boolean beautiful) {
        isBeautiful = beautiful;
    }

    @Override
    public String toString() {
        if (country != null && image != null)
            return "Марка{" +
                    "country='" + country + '\'' +
                    ", image='" + image + '\'' +
                    '}';
        return "Марка";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Stamp stamp = (Stamp) o;
        return isBeautiful == stamp.isBeautiful &&
                Objects.equals(country, stamp.country) &&
                Objects.equals(image, stamp.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(country, image, isBeautiful);
    }
}
