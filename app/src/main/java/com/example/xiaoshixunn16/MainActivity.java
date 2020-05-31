package com.example.xiaoshixunn16;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.xiaoshixunn16.bean.MainBean;
import com.example.xiaoshixunn16.presenter.ImpMainPresenter;
import com.example.xiaoshixunn16.view.MainView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener, MainView {

    private EditText et_name;
    private EditText et_psw;
    private Button btn_deng;
    private ImpMainPresenter impMainPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initView();
    }

    private void initView() {
        et_name = (EditText) findViewById(R.id.et_name);
        et_psw = (EditText) findViewById(R.id.et_psw);
        btn_deng = (Button) findViewById(R.id.btn_deng);

        btn_deng.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_deng:
                submit();
                break;
        }
    }

    private void submit() {
        // validate
        String name = et_name.getText().toString().trim();
        String psw = et_psw.getText().toString().trim();


        // TODO validate success, do something
        impMainPresenter = new ImpMainPresenter(this);

        impMainPresenter.mainData(name,psw);
    }

    @Override
    public void onSuccess(MainBean mainBean) {
    Toast.makeText(MainActivity.this,"登陆成功",Toast.LENGTH_LONG).show();
    }

    @Override
    public void onFail(String error) {

        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
    }
}