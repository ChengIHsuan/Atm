package com.hsuan.atm;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.ArrayList;

public class UserInfoActivity extends AppCompatActivity {

    private static final String TAG = Ch8Activity.class.getSimpleName();
    private EditText edNickname;
    private EditText edPhone;
    private String nickname;
    private String phone;
    private Spinner ages;

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

        ages = (Spinner) findViewById(R.id.ages);
        ArrayList<String> data = new ArrayList<>();
//        for (int i = 15; i <= 40; i++){
//            data.add(i+"");
//        }
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.ages, android.R.layout.simple_list_item_1);
        ages.setAdapter(adapter);
    }

    public void address(View view){
        startActivity(new Intent(this, CityActivity.class));
    }

    public void ok (View view){
        Log.d(TAG, "ok: " + ages.getSelectedItem().toString());
        int age = Integer.parseInt(ages.getSelectedItem().toString());
        nickname = edNickname.getText().toString();
        phone = edPhone.getText().toString();
        getIntent().putExtra("EXTRA_NICKNAME", nickname);
        getIntent().putExtra("EXTRA_PHONE", phone);
        setResult(RESULT_OK, getIntent());
        finish();
    }
}
