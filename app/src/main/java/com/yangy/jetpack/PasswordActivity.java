package com.yangy.jetpack;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class PasswordActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_password);
        String name = PasswordActivityArgs.fromBundle(getIntent().getExtras()).getName();
        String email = PasswordActivityArgs.fromBundle(getIntent().getExtras()).getEmail();
        Log.i("oye", "onCreate: name = " + name + "\nemail = " + email);
        findViewById(R.id.btn_register).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasswordActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}