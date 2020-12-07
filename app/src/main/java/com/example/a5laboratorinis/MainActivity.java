package com.example.a5laboratorinis;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    TextView tvContent;
    TextView showCurrency;
    TextView inputCurrency;
    ListView simpleListView;
    ArrayAdapter<String> adapter;
    ArrayList<String> arrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.tvContent = findViewById(R.id.tvContent);
        this.inputCurrency = findViewById(R.id.inputCurrency);
        this.simpleListView = findViewById(R.id.simpleListView);
        String[]currency={};
        arrayList=new ArrayList<>(Arrays.asList(currency));
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,arrayList);
        simpleListView.setAdapter(adapter);
    }

    public void onBtnDownloadClick(View view) {
        final String input = inputCurrency.getText().toString();
        this.tvContent.setText("Loading...");
        new DataLoader(){
            @Override
            public void onPostExecute(String result)
            {
                arrayList.add(input +" - "+ result);
                adapter.notifyDataSetChanged();
                // tvContent.setText(input +" - "+ result);
                tvContent.setText("Complete");
            }
        }.execute(input);
    }
}