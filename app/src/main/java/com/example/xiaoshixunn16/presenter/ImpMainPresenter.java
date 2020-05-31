package com.example.xiaoshixunn16.presenter;

import android.text.TextUtils;
import android.widget.Toast;

import com.example.xiaoshixunn16.bean.MainBean;
import com.example.xiaoshixunn16.callback.MainCallBack;
import com.example.xiaoshixunn16.model.ImpMainModel;
import com.example.xiaoshixunn16.view.MainView;

public class ImpMainPresenter implements MainPresenter, MainCallBack {
    private MainView mainView;
    private final ImpMainModel impMainModel;

    public ImpMainPresenter(MainView mainView) {
        this.mainView = mainView;
        impMainModel = new ImpMainModel();

    }


    @Override
    public void onSuccess(MainBean mainBean) {

        mainView.onSuccess(mainBean);
    }

    @Override
    public void onFail(String error) {
        mainView.onFail(error);
    }

    @Override
    public void mainData(String name, String psw) {
        if (TextUtils.isEmpty(name)) {
            mainView.onFail("name不能为空");
            return;
        }
        if (TextUtils.isEmpty(psw)) {
            mainView.onFail("psw不能为空");
            return;
        }

        impMainModel.mainData(name,psw,this);
    }
}
