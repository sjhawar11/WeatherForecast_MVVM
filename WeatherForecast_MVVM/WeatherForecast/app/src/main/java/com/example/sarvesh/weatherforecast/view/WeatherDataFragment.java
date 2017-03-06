package com.example.sarvesh.weatherforecast.view;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.sarvesh.weatherforecast.R;
import com.example.sarvesh.weatherforecast.databinding.WeatherFragmentLayoutBinding;
import com.example.sarvesh.weatherforecast.view.setup.ViewModelFragment;
import com.example.sarvesh.weatherforecast.viewmodel.WeatherViewModel;
import com.example.sarvesh.weatherforecast.viewmodel.setup.ViewModel;

/**
 * Created by Sarvesh on 04-03-2017.
 */

public class WeatherDataFragment extends ViewModelFragment {
    private WeatherViewModel weatherViewModel;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        WeatherFragmentLayoutBinding binding = DataBindingUtil.inflate(inflater, R.layout.weather_fragment_layout, container, false);
        View view = binding.getRoot();
        binding.setViewModel(weatherViewModel);
        return view;
    }

    @Override
    protected ViewModel createViewModel(@com.android.annotations.Nullable ViewModel.State savedViewModelState) {
        weatherViewModel = new WeatherViewModel(getContext(), savedViewModelState);
        return weatherViewModel;
    }
}
