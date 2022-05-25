package com.example.test_sysco.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.example.test_sysco.MyApplication;
import com.example.test_sysco.network.RetroServiceInterface;
import com.example.test_sysco.pojo.ResponseBean;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivityViewModel extends AndroidViewModel {

    private MutableLiveData<ResponseBean> liveDataList;
    @Inject
    RetroServiceInterface mService;

    public MainActivityViewModel(@NonNull Application application) {
        super(application);
        ((MyApplication) application).getRetroComponent().inject(MainActivityViewModel.this);
        liveDataList = new MutableLiveData<>();

    }

    public MutableLiveData<ResponseBean> getRecyclerListObserver() {
        return liveDataList;
    }

    public void makeApiCall(String pageNos) {

        Call<ResponseBean> call = mService.getDataFromAPiNEW(pageNos);

        call.enqueue(new Callback<ResponseBean>() {
            @Override
            public void onResponse(Call<ResponseBean> call, Response<ResponseBean> response) {
                if (response.isSuccessful()) {
                    liveDataList.postValue(response.body());
                } else {
                    liveDataList.postValue(null);
                }
            }
            @Override
            public void onFailure(Call<ResponseBean> call, Throwable t) {
                liveDataList.postValue(null);
            }
        });
    }
}
