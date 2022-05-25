package com.example.test_sysco.network;

import com.example.test_sysco.pojo.ResponseBean;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetroServiceInterface {

    @GET("planets/")
    Call<ResponseBean> getDataFromAPiNEW(@Query("page") String query);
}
