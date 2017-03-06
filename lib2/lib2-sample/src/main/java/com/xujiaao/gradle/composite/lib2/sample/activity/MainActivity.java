package com.xujiaao.gradle.composite.lib2.sample.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.xujiaao.gradle.composite.lib2.Lib2;
import com.xujiaao.gradle.composite.lib2.sample.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        ((TextView) findViewById(R.id.console)).setText(Lib2.getMessage());
    }
}