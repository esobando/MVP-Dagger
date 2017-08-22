package com.example.admin.mvp_dagger.injection.mainActivity;

import com.example.admin.mvp_dagger.View.MainActivity.MainActivityPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Admin on 8/21/2017.
 */

@Module
public class MainActivityModule
{
    @Provides
    MainActivityPresenter providesMainActivityPresenters(){
        return new MainActivityPresenter();
    }
}
