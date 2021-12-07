package com.gligamihai.traveljournal.ui.home;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.gligamihai.traveljournal.db.DateConverter;

import java.util.Date;

@Entity(tableName = "trips_table")
public class Trip {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "tripID")
    private int tripID;
    @ColumnInfo(name = "name")
    private String name;
    @ColumnInfo(name = "destination")
    private String destination;
    private String image;
    @ColumnInfo(name="type")
    private String type;
    @ColumnInfo(name="price")
    private int price;
    @ColumnInfo(name="start_date")
    @TypeConverters({DateConverter.class})
    private Date startDate;
    @ColumnInfo(name="end_date")
    @TypeConverters({DateConverter.class})
    private Date endDate;
    @ColumnInfo(name="rating")
    private int rating;

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

    public int getTripID() {
        return tripID;
    }

    public void setTripID(int tripID) {
        this.tripID = tripID;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public Trip(int tripID, String name, String destination, String image, String type, int price, Date startDate, Date endDate, int rating) {
        this.tripID = tripID;
        this.name = name;
        this.destination = destination;
        this.image = image;
        this.type = type;
        this.price = price;
        this.startDate = startDate;
        this.endDate = endDate;
        this.rating = rating;
    }

    public Trip(String name, String destination, String image) {
        this.name = name;
        this.destination = destination;
        this.image = image;
    }
}
