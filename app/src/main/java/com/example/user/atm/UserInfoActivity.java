package com.example.user.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class UserInfoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);
    }

    public void login (View view){
        EditText userNickname = (EditText) findViewById(R.id.ed_nickname);
        EditText userPhone = (EditText) findViewById(R.id.ed_phone);
        String nickcame = userNickname.getText().toString();
        String phone = userPhone.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("EXTRA_NAME", nickcame);
        intent.putExtra("EXTRA_PHONE", phone);
        startActivity(intent);
    }
}
