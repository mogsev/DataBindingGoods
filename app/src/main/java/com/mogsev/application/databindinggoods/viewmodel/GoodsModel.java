package com.mogsev.application.databindinggoods.viewmodel;

import android.databinding.ObservableField;
import android.databinding.ObservableInt;

import com.mogsev.application.databindinggoods.model.Goods;

public class GoodsModel {
    private static final String TAG = "GoodsModel";

    public final ObservableField<String> title = new ObservableField<String>();
    public final ObservableField<String> description = new ObservableField<>();
    public final ObservableInt price = new ObservableInt();
    public final ObservableField<String> country = new ObservableField<>();

    private Goods goods;

    public GoodsModel() {

    }

    public GoodsModel(Goods goods) {
        this.goods = goods;
    }

    public ObservableField<String> getTitle() {
        return title;
    }

    public ObservableField<String> getDescription() {
        return description;
    }

    public ObservableInt getPrice() {
        return price;
    }

    public ObservableField<String> getCountry() {
        return country;
    }
}
