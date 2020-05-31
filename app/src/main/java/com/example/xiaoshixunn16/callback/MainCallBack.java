package com.example.xiaoshixunn16.callback;

import com.example.xiaoshixunn16.bean.MainBean;

public interface MainCallBack {
    void onSuccess(MainBean mainBean);
    void onFail(String error);

}
