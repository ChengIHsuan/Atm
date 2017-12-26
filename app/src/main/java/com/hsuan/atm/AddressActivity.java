package com.hsuan.atm;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class AddressActivity extends AppCompatActivity {

    private Spinner spiCity;
    private Spinner spiArea;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_address);

        spiCity = (Spinner) findViewById(R.id.spi_city);
        spiArea = (Spinner) findViewById(R.id.spi_area);
        ArrayAdapter adarter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new String[] {"AA", "BB", "CC"});
        spiCity.setAdapter(adarter);
        spiCity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int position, long l) {
                String[] data = null;
                switch(position){
                    case 0:
                        data = new String[]{"1", "2", "3"};
                        break;
                    case 1:
                        data = new String[]{"4", "5", "6"};
                        break;
                    case 2:
                        data = new String[]{"7", "8", "9"};
                        break;
                }
                ArrayAdapter adapter1 = new ArrayAdapter(AddressActivity.this, android.R.layout.simple_list_item_1, data);
                spiArea.setAdapter(adapter1);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }



}
