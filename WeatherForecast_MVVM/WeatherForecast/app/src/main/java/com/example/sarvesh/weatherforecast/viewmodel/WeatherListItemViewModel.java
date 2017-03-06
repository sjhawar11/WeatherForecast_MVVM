package com.example.sarvesh.weatherforecast.viewmodel;

import android.databinding.Bindable;

import com.example.sarvesh.weatherforecast.model.DailyWeather;
import com.example.sarvesh.weatherforecast.viewmodel.setup.ItemViewModel;

/**
 * Created by Sarvesh on 05-03-2017.
 */

public class WeatherListItemViewModel extends ItemViewModel<DailyWeather> {
    private DailyWeather dailyWeather;
    @Override
    public void setItem(DailyWeather item) {
        dailyWeather = item;
    }

    @Bindable
    public DailyWeather getDailyWeather(){
        return dailyWeather;
    }
}
