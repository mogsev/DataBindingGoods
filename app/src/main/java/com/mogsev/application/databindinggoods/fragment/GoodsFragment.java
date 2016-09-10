package com.mogsev.application.databindinggoods.fragment;

import android.databinding.DataBindingUtil;
import android.databinding.ObservableBoolean;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mogsev.application.databindinggoods.R;
import com.mogsev.application.databindinggoods.adapter.RVGoodsAdapter;
import com.mogsev.application.databindinggoods.databinding.FragmentGoodsBinding;
import com.mogsev.application.databindinggoods.model.Goods;

public class GoodsFragment extends Fragment {
    public static final String TAG = "GoodsFragment";

    public final ObservableBoolean isFilter = new ObservableBoolean(false);

    private RecyclerView recyclerView;
    private RVGoodsAdapter rvGoodsAdapter;

    private RecyclerView recyclerViewFilter;
    private RVGoodsAdapter rvGoodsAdapterFilter;

    public GoodsFragment() {
    }

    public static GoodsFragment newInstance() {
        GoodsFragment fragment = new GoodsFragment();
        return fragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG, "onCreate");
        rvGoodsAdapter = new RVGoodsAdapter(this);
        rvGoodsAdapterFilter = new RVGoodsAdapter(this);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        FragmentGoodsBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_goods, container, false);
        binding.setAdapter(rvGoodsAdapter);
        binding.setAdapterFilter(rvGoodsAdapterFilter);
        binding.setFragment(this);
        View view = binding.getRoot();

        recyclerView = (RecyclerView) view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(rvGoodsAdapter);

        recyclerViewFilter = (RecyclerView) view.findViewById(R.id.recyclerViewFilter);
        recyclerViewFilter.setLayoutManager(new GridLayoutManager(getActivity(), 2));
        recyclerViewFilter.setItemAnimator(new DefaultItemAnimator());
        recyclerViewFilter.setAdapter(rvGoodsAdapterFilter);
        return view;
    }

    public ObservableBoolean getIsFilter() {
        return isFilter;
    }

    public boolean onFilterCountry(@NonNull final Goods goods) {
        Log.i(TAG, "onFilter: " + goods.getCountry());
        isFilter.set(!isFilter.get());
        if (isFilter.get()) {
            rvGoodsAdapterFilter.getList().clear();
            for (Goods g : rvGoodsAdapter.getList()) {
                if (g.getCountry().equals(goods.getCountry())) {
                    rvGoodsAdapterFilter.getList().add(g);
                    rvGoodsAdapterFilter.notifyDataSetChanged();
                }
            }
        }
        return true;
    }
}
