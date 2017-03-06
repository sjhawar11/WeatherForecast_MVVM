package com.example.sarvesh.weatherforecast.view;

import android.databinding.ViewDataBinding;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sarvesh.weatherforecast.R;
import com.example.sarvesh.weatherforecast.databinding.WeatherRowLayoutBinding;
import com.example.sarvesh.weatherforecast.model.DailyWeather;
import com.example.sarvesh.weatherforecast.viewmodel.WeatherListItemViewModel;
import com.example.sarvesh.weatherforecast.viewmodel.setup.RecyclerViewAdapter;

import java.util.ArrayList;

/**
 * Created by Sarvesh on 04-03-2017.
 */

public class WeatherDataAdapter extends RecyclerViewAdapter<DailyWeather, WeatherListItemViewModel> {
    public void setItems(ArrayList<DailyWeather> newItems) {
        items.clear();
        items.addAll(newItems);
        notifyDataSetChanged();
    }

    @Override
    public WeatherDataHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_row_layout, parent, false);
        WeatherListItemViewModel itemViewModel = new WeatherListItemViewModel();
        WeatherRowLayoutBinding binding = WeatherRowLayoutBinding.bind(view);
        binding.setViewModel(itemViewModel);
        return new WeatherDataHolder(view, binding, itemViewModel);
    }

    public class WeatherDataHolder extends ItemViewHolder<DailyWeather, WeatherListItemViewModel>{
        public WeatherDataHolder(View itemView, ViewDataBinding binding,
                                 WeatherListItemViewModel viewModel) {
            super(itemView, binding, viewModel);
        }
    }
}
