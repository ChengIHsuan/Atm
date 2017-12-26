package com.hsuan.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.Toast;

public class AddressActivity extends AppCompatActivity {

    private Spinner spiCity;
    private Spinner spiArea;
    private String[] city;
    private String[] area;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        spiCity = (Spinner) findViewById(R.id.spi_city);
        spiArea = (Spinner) findViewById(R.id.spi_area);
        city = new String[]{"新北市", "台北市", "基隆市", "桃園市"};
        ArrayAdapter adarter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, city);
        spiCity.setAdapter(adarter);
        spiCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, final int position, long l) {
                area = null;
                switch(position){
                    case 0:
                        area = new String[]{"新莊區", "板橋區", "中和區", "三重區", "新店區", "土城區", "永和區", "蘆洲區", "汐止區", "樹林區", "淡水區", "三峽區", "林口區", "鶯歌區", "五股區", "泰山區", "瑞芳區", "八里區", "深坑區", "三芝區", "萬里區", "金山區", "貢寮區", "石門區", "雙溪區", "石碇區", "坪林區", "烏來區", "平溪區"};
                        break;
                    case 1:
                        area = new String[]{"大安區", "士林區", "內湖區", "文山區", "北投區", "中山區", "信義區", "松山區", "萬華區", "中正區", "大同區", "南港區"};
                        break;
                    case 2:
                        area = new String[]{"仁愛區", "中正區", "信義區", "中山區", "安樂區", "七堵區", "暖暖區"};
                        break;
                    case 3:
                        area = new String[]{"桃園區", "中壢區", "平鎮區", "八德區", "楊梅區", "蘆竹區", "龜山區", "龍潭區", "大溪區", "大園區", "觀音區", "新屋區", "復興區"};
                        break;
                }
                ArrayAdapter adapter1 = new ArrayAdapter(AddressActivity.this, android.R.layout.simple_list_item_1, area);
                spiArea.setAdapter(adapter1);
                spiArea.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                        Toast.makeText(AddressActivity.this, (city[position] + area[i]), Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onNothingSelected(AdapterView<?> adapterView) {

                    }
                });
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



}
