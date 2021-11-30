package com.gligamihai.traveljournal.retrofit;

import com.google.gson.annotations.SerializedName;

public class WeatherData {

    @SerializedName("main")
    private Weather weather;

    public Weather getWeather() {
        return weather;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }
}
