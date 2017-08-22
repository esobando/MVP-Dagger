package com.example.admin.mvp_dagger.View.MainActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;

/**
 * Created by Admin on 8/21/2017.
 */

public class MainActivityPresenter implements MainActivityContract.Presenter {
    MainActivityContract.View view;
    private static final String TAG = "MainPresenterTag";
    Context context;

    public void attachView(MainActivityContract.View view) {
        this.view = view;
    }

    @Override
    public void removeView() {
        this.view = null;
    }

    @Override
    public void savePerson(String person) {
        Log.d(TAG, "savePerson: " + person);

        SharedPreferences sharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("person", person);
        boolean isSaved = editor.commit();
        view.isPersonSaved(true);
    }

    @Override
    public String getPerson() {
        String person = "";
        SharedPreferences sharedPreferences = context.getSharedPreferences("myPref", Context.MODE_PRIVATE);
        sharedPreferences.getString("person", "DEFAULT");
        return person;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }
}
