package com.simplesqlite.ExchangeRates;

import android.app.Activity;
import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.util.Log;
import org.json.JSONObject;

import org.json.JSONException;
import com.simplesqlite.R;

/**
 * Created by fff on 12.12.2015.
 */
public class ExchangeScreen extends Activity {

    private final String URL_UAH_TO_USD =
            "http://rate-exchange-1.appspot.com/currency?from=USD&to=UAH&q=1";
    private final String URL_UAH_TO_EUR =
            "http://rate-exchange-1.appspot.com/currency?from=EUR&to=UAH&q=1";

    private Currency currency;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.exchange_layout);

        currency = new Currency();

        new PrefetchDataCurrency().execute();
    }

    private class PrefetchDataCurrency extends AsyncTask<Void, Void, Void>{

        @Override
        protected Void doInBackground(Void... params) {

            JSONObject jsonUAHtoUSD = JSONParser.getJSONFromUrl(URL_UAH_TO_USD);
            JSONObject jsonUAHtoEUR = JSONParser.getJSONFromUrl(URL_UAH_TO_EUR);

            if (jsonUAHtoUSD != null && jsonUAHtoEUR != null){
                try {
                    currency.setCurrencyFirst(jsonUAHtoUSD.getDouble("rate"));
                    currency.setCurrencySecond(jsonUAHtoEUR.getDouble("rate"));
                } catch (JSONException e){
                    Log.e(PrefetchDataCurrency.class.getName(),"Not valid JSON data");
                }
            }

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

            Intent intent = new Intent(ExchangeScreen.this, ExchangeActivity.class);
            intent.putExtra("currency", currency);

            startActivity(intent);
            finish();
        }
    }
}
