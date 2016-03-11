package com.simplesqlite.ExchangeRates;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.simplesqlite.R;

/**
 * Created by fff on 12.12.2015.
 */
public class ExchangeActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exchange);
        TextView textUAH = (TextView) findViewById(R.id.textUAH);
        TextView textUSD = (TextView) findViewById(R.id.textUSD);

        Currency currency = (Currency) getIntent().getSerializableExtra("currency");

        textUAH.setText(String.valueOf(currency.getCurrencyFirst()));
        textUSD.setText(String.valueOf(currency.getCurrencySecond()));
    }
}
