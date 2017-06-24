package ru.itis;

import com.google.common.base.MoreObjects;

public class Artist {
    private String from;
    private String name;

    public Artist(String from, String name) {
        this.from = from;
        this.name = name;
    }

    public String getFrom() {
        return from;
    }

    public String getName() {
        return name;
    }

    public boolean isFrom(String country) {
        return from.equals(country);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("from", from)
                .add("name", name)
                .toString();
    }
}
