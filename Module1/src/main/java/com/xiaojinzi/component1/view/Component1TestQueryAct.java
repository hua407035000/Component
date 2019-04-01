package com.xiaojinzi.component1.view;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xiaojinzi.base.ModuleConfig;
import com.xiaojinzi.component.anno.RouterAnno;
import com.xiaojinzi.component.impl.RouterRequest;
import com.xiaojinzi.component.support.ParameterSupport;
import com.xiaojinzi.component1.R;

/**
 * 我是一个测试query传递参数的界面
 */
public class Component1TestQueryAct extends AppCompatActivity {

    @RouterAnno(
            host = ModuleConfig.Module1.NAME,
            path = ModuleConfig.Module1.TEST_QUERY
    )
    public static Intent createIntent(RouterRequest request) {
        Intent intent = new Intent(request.getRawContext(), Component1TestQueryAct.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.component1_test_query_act);

        TextView tv_name = findViewById(R.id.tv_name);
        TextView tv_pass = findViewById(R.id.tv_pass);

        String name = ParameterSupport.getString(getIntent(), "name", null);
        String pass = ParameterSupport.getString(getIntent(), "pass", null);

        tv_name.setText(name);
        tv_pass.setText(pass);

    }

}