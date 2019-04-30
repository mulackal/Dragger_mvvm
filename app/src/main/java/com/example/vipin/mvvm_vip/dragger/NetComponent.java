package com.example.vipin.mvvm_vip.dragger;

import com.example.vipin.mvvm_vip.app_datas.AppDataManager;
import com.example.vipin.mvvm_vip.repository.MainRepository;
import com.example.vipin.mvvm_vip.view.MainActivity;
import com.example.vipin.mvvm_vip.viewmodel.MainViewModel;

import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by vipin on 20/2/17.
 */

@Singleton
@Component(modules={AppModule.class, NetModule.class})
public interface NetComponent {

    void inject(MainActivity activity);
    void inject(AppDataManager share);
    void inject(MyApp myApp);
    void inject(MainViewModel mainViewModel);
    void inject(MainRepository mainRepository);

    // void inject(Fragment_Drag fragment);
    /*// dragger in fragment inject
        ((MyApp) getActivity().getApplication()).getNetComponent().inject(this);*/
}