package com.example.xiaoshixunn16.model;

import com.example.xiaoshixunn16.api.ApiService;
import com.example.xiaoshixunn16.bean.MainBean;
import com.example.xiaoshixunn16.callback.MainCallBack;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ImpMainModel implements MainModel{


    @Override
    public void mainData(String name, String psw, final MainCallBack mainCallBack) {
        Retrofit retrofit = new Retrofit.Builder()
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(ApiService.baseUrl)
                .build();
        ApiService apiService = retrofit.create(ApiService.class);

        Observable<MainBean> observable = apiService.login(name, psw);

        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MainBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(MainBean mainBean) {
                        int errorCode = mainBean.getErrorCode();
                        if (errorCode==0){
                            mainCallBack.onSuccess(mainBean);
                        }else {
                            mainCallBack.onFail(mainBean.getErrorMsg());
                        }


                    }

                    @Override
                    public void onError(Throwable e) {
                        mainCallBack.onFail("登录错误"+e.getMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
