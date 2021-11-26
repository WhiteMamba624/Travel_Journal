package com.gligamihai.traveljournal.ui.home;

public class Trip {
    private String name;
    private String destination;
    private String image;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "name='" + name + '\'' +
                ", destination='" + destination + '\'' +
                ", image='" + image + '\'' +
                '}';
    }

    public Trip(String name, String destination, String image) {
        this.name = name;
        this.destination = destination;
        this.image = image;
    }
}
