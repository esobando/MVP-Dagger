package com.example.admin.mvp_dagger.injection.mainActivity;

import com.example.admin.mvp_dagger.View.MainActivity.MainActivity;

import dagger.Component;

/**
 * Created by Admin on 8/21/2017.
 */
@Component(modules = MainActivityModule.class)
public interface MainActivityComponent {

    void inject(MainActivity mainActivity);

}
