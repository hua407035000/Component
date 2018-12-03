package com.ehi.component1.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.ehi.component.anno.EHiRouterAnno;
import com.ehi.component.support.QueryParameterSupport;
import com.ehi.component1.R;
import com.ehi.component1.interceptor.Component1Interceptor1;
import com.ehi.component1.interceptor.Component1Interceptor2;

@EHiRouterAnno(
        host = "component1",
        value = "test",
        interceptors = {Component1Interceptor1.class, Component1Interceptor2.class},
        desc = "业务组件1的测试界面"
)
public class Component1TestAct extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.component1_test_act);

        TextView tv_data = findViewById(R.id.tv_data);
        tv_data.setText(QueryParameterSupport.getString(getIntent(), "data"));

        String data = getIntent().getStringExtra("data");

        if (data != null) {
            tv_data.setText(tv_data.getText() + "\n" + data);
        }

    }

    public void returnData(View view) {
        Intent intent = new Intent();
        intent.putExtra("data", "this is the return data");
        setResult(RESULT_OK, intent);
        finish();
    }

}
