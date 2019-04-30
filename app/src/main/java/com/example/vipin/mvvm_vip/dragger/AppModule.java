package com.example.vipin.mvvm_vip.dragger;

import android.app.Application;
import android.content.Context;

import com.example.vipin.mvvm_vip.app_datas.AppConstants;
import com.example.vipin.mvvm_vip.app_datas.AppDataManager;
import com.example.vipin.mvvm_vip.app_datas.User;
import com.example.vipin.mvvm_vip.repository.MainRepository;
import com.example.vipin.mvvm_vip.utilities.InternetConnection;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by vipin on 20/2/17.
 */

@Module
public class AppModule {

    Application mApplication;

    public AppModule(Application application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return mApplication;
    }

    @Provides
    @Singleton
    Context provideContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    AppConstants provideConstants()
    {
        AppConstants data = new AppConstants();
        return data;
    }

    // app storage class  **********

    @Provides
    @Singleton
    AppDataManager providePreference()
    {
        AppDataManager shpreference = new AppDataManager(mApplication);
        return shpreference;
    }


    @Provides
    @Singleton
    User providesUser() {
        return new User();
    }

    @Provides
    @Singleton
    MainRepository providesRepository() {
        return new MainRepository(mApplication);
    }


}