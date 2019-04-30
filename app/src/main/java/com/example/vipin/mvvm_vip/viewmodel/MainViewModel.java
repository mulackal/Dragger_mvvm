package com.example.vipin.mvvm_vip.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.content.Context;
import android.databinding.ObservableArrayList;
import android.databinding.ObservableBoolean;
import android.databinding.ObservableField;
import android.databinding.ObservableList;
import android.util.Log;
import android.widget.Toast;


import com.example.vipin.mvvm_vip.app_datas.AppDataManager;
import com.example.vipin.mvvm_vip.dragger.MyApp;
import com.example.vipin.mvvm_vip.model.Notification_;
import com.example.vipin.mvvm_vip.repository.MainRepository;
import com.example.vipin.mvvm_vip.utilities.InternetConnection;

import java.util.List;

import javax.inject.Inject;


public class MainViewModel extends AndroidViewModel {

    // observable fields on the
    public final ObservableList<Notification_> mDataList = new ObservableArrayList<>();

    public final ObservableField<String> sample = new ObservableField<>();

    public final ObservableBoolean errorLoading = new ObservableBoolean(false);

    public MutableLiveData<Boolean> isLoading = new MutableLiveData<>();

    @Inject MainRepository mRepository;

    @Inject InternetConnection connection;

    @Inject AppDataManager appDataManager;

    Context mcontext;

    public MainViewModel(Application application) {
        super(application);

         mcontext = application;

        // dragger
        ((MyApp) getApplication()).getNetComponent().inject(this);

        sample.set(appDataManager.user.userName); // session value store to text view
    }


    public void CallNotification(int count){

        if(connection.isConnected(mcontext)){

        isLoading.setValue(true);

        Log.e("callt","create-model");

        mRepository.CallNotificationList(this,count);

        }else{
            Log.e("callt","model-no Network");
            sample.set("No Network");
        }
    }

    public void setNotification(List<Notification_> notifications) {


        isLoading.setValue(false);

        mDataList.clear();
        mDataList.addAll(notifications);

         Log.e("size","data: "+mDataList.size());


         sample.set(mDataList.get(1).getTitle());


    }

    public void ShowErrorSnak(String message){

        Log.e("error",""+message);

        isLoading.setValue(false);

        errorLoading.set(true);

        // session to value store use dragger injection object
        appDataManager.user.userName = "Fetched by Vipin";
        appDataManager.saveUser();

        sample.set(appDataManager.user.userName);


    }

    public  void OnClickPerform(){

        Toast.makeText(mcontext, "Your Text ME!", Toast.LENGTH_SHORT).show();
    }


}
