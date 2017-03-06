package com.xujiaao.gradle.composite.demo.activity;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.xujiaao.gradle.composite.demo.R;
import com.xujiaao.gradle.composite.lib1.Lib1;
import com.xujiaao.gradle.composite.lib2.Lib2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {
        final TextView console = (TextView) findViewById(R.id.console);
        console.append(avoidNull(Lib1.getMessage()));
        console.append("\n");
        console.append(avoidNull(Lib2.getMessage()));
    }

    private static CharSequence avoidNull(CharSequence charSequence) {
        return charSequence != null ? charSequence : "";
    }
}