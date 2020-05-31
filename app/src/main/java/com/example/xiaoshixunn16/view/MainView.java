package com.example.xiaoshixunn16.view;

import com.example.xiaoshixunn16.bean.MainBean;

public interface MainView {
    void onSuccess(MainBean mainBean);
    void onFail(String error);

}
