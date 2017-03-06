package com.example.sarvesh.weatherforecast.model;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Sarvesh on 04-03-2017.
 */

public class DailyWeather {
    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd /MMM");
    private Temp temp;
    private long dt;
    //private Weather weather;

    public String getDt() {
        Date date = new Date(dt * 1000l);
        String formattedDay = simpleDateFormat.format(date);
        return formattedDay;
    }
    public void setDt(long dt) {
        this.dt = dt;
    }

    public Temp getTemp() {
        return temp;
    }

    public void setTemp(Temp temp) {
        this.temp = temp;
    }

//    public Weather getWeather() {
//        return weather;
//    }
//
//    public void setWeather(Weather weather) {
//        this.weather = weather;
//    }
}
