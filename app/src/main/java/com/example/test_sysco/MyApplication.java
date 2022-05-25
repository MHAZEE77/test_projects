package com.example.test_sysco;

import android.app.Application;

import com.example.test_sysco.network.DaggerRetroComponent;
import com.example.test_sysco.network.RetroComponent;
import com.example.test_sysco.network.RetroModule;

public class MyApplication extends Application {

    RetroComponent retroComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        retroComponent = DaggerRetroComponent.builder()
                .retroModule(new RetroModule(this))
                .build();
        
    }
    public RetroComponent getRetroComponent (){
        return retroComponent;
    }
}
