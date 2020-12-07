package com.example.a5laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    TextView showCurrency;
    TextView inputCurrency;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
        this.showCurrency = findViewById(R.id.showCurrency);
        this.inputCurrency = findViewById(R.id.inputCurrency);
    }

    public void onBtnDownloadClick(View view) {
        String input = inputCurrency.getText().toString();
        showCurrency.setText(input);
        this.tvContent.setText("Loading...");
        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                tvContent.setText(result);
            }
        }.execute(input);
    }
}