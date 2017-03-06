package com.example.sarvesh.weatherforecast.viewmodel;

import android.content.Context;
import android.databinding.ObservableField;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.VolleyError;
import com.example.sarvesh.weatherforecast.view.WeatherDataAdapter;
import com.example.sarvesh.weatherforecast.model.WeatherApiModel;
import com.example.sarvesh.weatherforecast.network.NetworkManager;
import com.example.sarvesh.weatherforecast.network.OnResponse;
import com.example.sarvesh.weatherforecast.network.WeatherRequest;
import com.example.sarvesh.weatherforecast.viewmodel.setup.RecyclerViewAdapter;
import com.example.sarvesh.weatherforecast.viewmodel.setup.RecyclerViewViewModel;

/**
 * Created by Sarvesh on 04-03-2017.
 */

public class WeatherViewModel extends RecyclerViewViewModel implements OnResponse {
    private final static String REQUEST_BY_NAME = "http://api.openweathermap.org/data/2.5/forecast/daily?q={CITY_NAME}&mode=json&units=metric&cnt=14&APPID=7eb68a19c6786f425839b6ffa00a6b69";
    private RequestQueue requestQueue;
    private final Context appContext;
    private WeatherDataAdapter adapter;

    public final ObservableField<String> searchText = new ObservableField<>();

    public WeatherViewModel(Context context, @Nullable State savedInstanceState){
        super(savedInstanceState);
        requestQueue = NetworkManager.getRequestQueue(context);
        appContext = context;
        adapter = new WeatherDataAdapter();
    }

    private void makeRequestByCityName(String cityName){
        String url = REQUEST_BY_NAME.replace("{CITY_NAME}", cityName);
        WeatherRequest<WeatherApiModel> request = new WeatherRequest<WeatherApiModel>(Request.Method.GET, url, this, this, WeatherApiModel.class );
        requestQueue.add(request);
    }

    @Override
    public void onErrorResponse(VolleyError error) {

    }

    @Override
    public void onResponse(Object response) {
        if(response instanceof WeatherApiModel){
            WeatherApiModel weatherApiModel = (WeatherApiModel)response;
            adapter.setItems(weatherApiModel.getList());
        }
    }

    public void onSearchClick(){
        makeRequestByCityName(searchText.get());
    }

    @Override
    protected RecyclerViewAdapter getAdapter() {
        return adapter;
    }

    @Override
    protected RecyclerView.LayoutManager createLayoutManager() {
        return new LinearLayoutManager(appContext);
    }
}
