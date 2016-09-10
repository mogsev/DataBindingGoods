package com.mogsev.application.databindinggoods.demo;

import com.mogsev.application.databindinggoods.model.Goods;

import java.util.ArrayList;
import java.util.List;

public final class Demo {
    private static final String TAG = "Demo";

    public static List<Goods> getListGoods() {
        List<Goods> list = new ArrayList<>();
        list.add(new Goods(1, "Picacy", "Ukraine", 100));
        list.add(new Goods(2, "Tylka", "China", 200));
        list.add(new Goods(3, "Tiramisy", "Moldova", 300));
        list.add(new Goods(4, "KitKat", "Rasha", 400));
        list.add(new Goods(5, "Myr-Myr", "USA", 500));
        list.add(new Goods(6, "Kilka", "England", 600));
        list.add(new Goods(7, "Meat", "Ukraine", 700));
        list.add(new Goods(8, "Cherry", "Poland", 800));
        list.add(new Goods(9, "Apple", "China", 900));
        list.add(new Goods(10, "Meat", "USA", 1000));
        return list;
    }
}
