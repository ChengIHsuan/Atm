package com.example.user.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class UserInfoActivity extends AppCompatActivity {

    private EditText edNickname;
    private EditText edPhone;
    private String nickname;
    private String phone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_info);

        edNickname = (EditText) findViewById(R.id.ed_nickname);
        edPhone = (EditText) findViewById(R.id.ed_phone);
        nickname = getSharedPreferences("atm", MODE_PRIVATE)
                .getString("NICKNAME", "");
        edNickname.setText(nickname);
        phone = getSharedPreferences("atm", MODE_PRIVATE)
                .getString("PHONE", "");
        edPhone.setText(phone);
    }

    public void ok (View view){
        nickname = edNickname.getText().toString();
        phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}
