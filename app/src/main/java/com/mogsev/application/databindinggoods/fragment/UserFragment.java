package com.mogsev.application.databindinggoods.fragment;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.mogsev.application.databindinggoods.R;
import com.mogsev.application.databindinggoods.databinding.FragmentUserBinding;
import com.mogsev.application.databindinggoods.model.User;
import com.mogsev.application.databindinggoods.viewmodel.UserModel;

public class UserFragment extends Fragment {
    public static final String TAG = "UserFragment";

    private OnUserFragmentListener mListener;

    public UserFragment() {
    }

    public static UserFragment newInstance() {
        UserFragment fragment = new UserFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @NonNull ViewGroup container, @NonNull Bundle savedInstanceState) {
        Log.i(TAG, "onCreateView");
        FragmentUserBinding binding = DataBindingUtil.inflate(inflater, R.layout.fragment_user, container, false);
        binding.setUserModel(new UserModel(new User("Zhenya", "Sikaylo")));
        View view = binding.getRoot();
        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnUserFragmentListener) {
            mListener = (OnUserFragmentListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    public interface OnUserFragmentListener {
        void onChange(View view);
    }
}
