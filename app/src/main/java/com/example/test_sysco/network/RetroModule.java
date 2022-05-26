package com.example.test_sysco.network;


import android.content.Context;

import com.example.test_sysco.R;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetroModule {

//    private String base_url ="https://swapi.dev/api/";
    Context context;

    public RetroModule(Context context){
        this.context= context;
    }

    @Singleton
    @Provides
    public RetroServiceInterface getRetroServiceInterface (Retrofit  retrofit){
        return retrofit.create(RetroServiceInterface.class);
    }

    @Singleton
    @Provides
    public Retrofit getRetrofitInstrance(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.base_url))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        return retrofit;
    }

}
