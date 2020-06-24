package com.yangy.jetpack.ui;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.yangy.jetpack.R;
import com.yangy.jetpack.model.MainViewModel;
import com.yangy.jetpack.model.User;

public class MainActivity extends AppCompatActivity {
    private MainViewModel model;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setNavigationBarColor(Color.TRANSPARENT);
        getWindow().setStatusBarColor(Color.TRANSPARENT);
        model = new ViewModelProvider(MainActivity.this).get(MainViewModel.class);
        final TextView textView = findViewById(R.id.tv_user_name);
        final Button btn = findViewById(R.id.btn_set_name);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                model.getUsers().postValue(new User("YangY"));
            }
        });

        //观察数据是否发生变化，当发生变化时就会执行onChanged内的代码程序
        model.getUsers().observe(this, new Observer<User>() {
            @Override
            public void onChanged(User user) {
                textView.setText("我叫：" + user.getName());
            }
        });
    }
}