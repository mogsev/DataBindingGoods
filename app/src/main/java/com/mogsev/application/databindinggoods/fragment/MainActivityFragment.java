package com.mogsev.application.databindinggoods.fragment;

import android.databinding.DataBindingUtil;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mogsev.application.databindinggoods.MainActivity;
import com.mogsev.application.databindinggoods.R;
import com.mogsev.application.databindinggoods.databinding.FragmentMainBinding;
import com.mogsev.application.databindinggoods.helper.SettingsHelper;

public class MainActivityFragment extends Fragment {
    private static final String TAG = "MainActivityFragment";

    private static MainActivityFragment mInstance;
    private FragmentMainBinding binding;

    public MainActivityFragment() {
    }

    public static MainActivityFragment newInstance() {
        mInstance = new MainActivityFragment();
        return mInstance;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        Log.i(TAG, "ID: ".concat(String.valueOf(SettingsHelper.getInstance().getID())));
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_main, container, false);
        binding.setActivity((MainActivity) getActivity());
        binding.btnGoodsFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.getActivity().runFragmentTransaction(GoodsFragment.newInstance(), GoodsFragment.TAG);
            }
        });
        return binding.getRoot();
    }
}
