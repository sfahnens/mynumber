package com.github.skyborla.mynumber;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.telephony.PhoneNumberUtils;
import android.telephony.TelephonyManager;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.app_name);
        setSupportActionBar(toolbar);


        TelephonyManager tMgr = (TelephonyManager)getSystemService(Context.TELEPHONY_SERVICE);
        String number = tMgr.getLine1Number();

        if(number == null || number.trim().isEmpty()) {
            number = getString(R.string.error);
        } else {
            number = PhoneNumberUtils.formatNumber(number, "49"); // 'schland ;)
        }

        TextView text = (TextView) findViewById(R.id.textView);
        text.setText(number);
    }
}
