package com.example.sarvesh.weatherforecast.viewmodel.setup;

/**
 * Created by Sarvesh on 05-03-2017.
 */

public abstract class ItemViewModel<ITEM_T> extends ViewModel {

    public ItemViewModel() {
        super(null);
    }

    public abstract void setItem(ITEM_T item);
}
