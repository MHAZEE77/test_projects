package com.example.test_sysco.network;


import com.example.test_sysco.MainActivity;
import com.example.test_sysco.viewmodel.MainActivityViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {RetroModule.class})
public interface RetroComponent {

    void inject (MainActivityViewModel mainActivityViewModel);
    void inject(MainActivity mainActivity);
}
