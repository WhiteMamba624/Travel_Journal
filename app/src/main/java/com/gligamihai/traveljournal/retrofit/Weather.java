package com.gligamihai.traveljournal.retrofit;

import com.google.gson.annotations.SerializedName;

public class Weather {

    @SerializedName("temp")
    String temp;

    public String getTemp() {
        return temp;
    }

    public void setTemp(String temp) {
        this.temp = temp;
    }
}
