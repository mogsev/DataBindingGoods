package com.mogsev.application.databindinggoods.viewmodel;

import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableInt;
import android.util.Log;
import android.view.View;

import com.mogsev.application.databindinggoods.model.User;

public class UserModel {
    private static final String TAG = "UserModel";

    public final ObservableBoolean edit = new ObservableBoolean(false);
    public final ObservableInt visEdit = new ObservableInt(View.VISIBLE);
    public final ObservableInt visSave = new ObservableInt(View.GONE);
    public final ObservableField<String> firstName = new ObservableField<>();
    public final ObservableField<String> lastName = new ObservableField<>();

    private User user;

    public UserModel() {
    }

    public UserModel(User user) {
        this.user = user;
        this.firstName.set(user.getFirstName());
        this.lastName.set(user.getLastName());
    }

    public ObservableField<String> getFirstName() {
        return firstName;
    }

    public ObservableField<String> getLastName() {
        return lastName;
    }

    public boolean isEdit() {
        Log.i(TAG, "isEdit: " + edit.get() );
        return edit.get();
    }

    public boolean setEdit() {
        Log.i(TAG, "setEdit: " + edit.get() );
        edit.set(!edit.get());
        if (edit.get()) {
            visEdit.set(View.GONE);
            visSave.set(View.VISIBLE);
        } else {
            visEdit.set(View.VISIBLE);
            visSave.set(View.GONE);
        }
        user.setFirstName(firstName.get());
        user.setLastName(lastName.get());
        return edit.get();
    }

    public ObservableBoolean getEdit() {
        return edit;
    }

    public ObservableInt getVisEdit() {
        return visEdit;
    }

    public ObservableInt getVisSave() {
        return visSave;
    }

    public User getUser() {
        return user;
    }
}
