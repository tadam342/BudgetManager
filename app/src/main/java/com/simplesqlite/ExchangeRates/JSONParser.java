package com.simplesqlite.ExchangeRates;
/**
 * Created by fff on 08.12.2015.
 */
import android.util.Log;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class JSONParser {

    public static JSONObject getJSONFromUrl(String url) {
        StringBuilder builder = new StringBuilder();
        // Создаем HTTP клиент, который позволит работать с HTTP запросами
        HttpClient client = new DefaultHttpClient();
        // Формируем HTTP запрос методом GET
        HttpGet httpGet = new HttpGet(url);

        int statusCode = 0;
        try {
            // выполняем запрос и получаем ответ
            HttpResponse response = client.execute(httpGet);
            // получаем статус ответа
            StatusLine statusLine = response.getStatusLine();
            statusCode = statusLine.getStatusCode();
            // если запрос удачный, то выполняем парсинг данных
            if (statusCode == 200) {
                HttpEntity entity = response.getEntity();
                InputStream content = entity.getContent();
                BufferedReader reader = new BufferedReader(new InputStreamReader(content));
                String line;
                // получаем JSON строку
                while ((line = reader.readLine()) != null) {
                    builder.append(line);
                }
            } else {
                Log.e(JSONParser.class.toString(), "Failed to get currency data.");
            }
        } catch (IOException e) {
            Log.e(JSONParser.class.toString(), "Failed status code = " + statusCode);
        }

        JSONObject jsonObject = null;
        try {
            // формируем JSON объект
            jsonObject = new JSONObject(builder.toString());
        } catch (JSONException e) {
            Log.e(JSONParser.class.getName(), "Not valid JSON data.");
        }

        // возвращаем сформированный JSON объект
        return jsonObject;
    }
}