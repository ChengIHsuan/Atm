package com.hsuan.atm;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    boolean logon = false;

    public static final int FUNC_LOGIN = 1;
    public static final int FUNC_INFO = 2;

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        switch (requestCode) {
            case FUNC_LOGIN:
                if (resultCode == RESULT_OK) {
                    String userid = data.getStringExtra("LOGIN_USERID");
                    Toast.makeText(this, "Hello,  " + userid, Toast.LENGTH_SHORT).show();
                    getSharedPreferences("atm", MODE_PRIVATE)
                            .edit()
                            .putString("USERID", userid)
                            .apply();
                } else {
                    finish();
                }
                break;
            case FUNC_INFO:
                if (resultCode == RESULT_OK) {
                    String nickname = data.getStringExtra("EXTRA_NICKNAME");
                    String phone = data.getStringExtra("EXTRA_PHONE");
                    Toast.makeText(this, "暱稱 : " + nickname + ", 電話 : " + phone, Toast.LENGTH_SHORT).show();
                    getSharedPreferences("atm", MODE_PRIVATE)
                            .edit()
                            .putString("NICKNAME", nickname)
                            .putString("PHONE", phone)
                            .apply();
                } else {
                    finish();
                }
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, UserInfoActivity.class);
                startActivityForResult(intent, FUNC_INFO);
            }
        });

//        startActivity(new Intent(this, FinanceActivity.class));

        if (!logon) {
            Intent intent = new Intent(this, LoginActivity.class);
            startActivityForResult(intent, FUNC_LOGIN);
        }
    }

    public void ch8(View view) {
        startActivity(new Intent(this, Ch8Activity.class));
    }
    public void finance(View view) {
        startActivity(new Intent(this, FinanceActivity.class));
    }
    public void address(View view) { startActivity(new Intent(this, AddressActivity.class));}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
