package com.example.xiaoshixunn16.api;

import com.example.xiaoshixunn16.bean.MainBean;

import io.reactivex.Observable;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    String baseUrl="https://wanandroid.com/";
    @POST("user/login")
    @FormUrlEncoded
    Observable<MainBean> login(@Field("username") String username, @Field("password") String password);
}
