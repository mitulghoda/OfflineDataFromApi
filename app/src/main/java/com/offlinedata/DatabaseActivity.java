package com.offlinedata;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import com.offlinedata.Resonse.ListResoponse;
import com.offlinedata.Resonse.MainResponse;
import com.offlinedata.WebServices.ApiHandler;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

public class DatabaseActivity extends AppCompatActivity {

    ListView lv;
    TextView txt_next;
    List<Contact> listResoponses;
    DataBaseListAdapter listAdapter;
    DatabaseHandler db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idMapping();
        db = new DatabaseHandler(this);

        setDatabaseList();
        setOnclick();
    }

    private void setDatabaseList() {

        List<Contact> contacts = db.getAllContacts();
        for (int i = 0; i < contacts.size(); i++) {
            Log.e("AllData", String.valueOf(contacts));
        }

        listAdapter = new DataBaseListAdapter(DatabaseActivity.this, contacts);
        lv.setAdapter(listAdapter);


    }


    private void idMapping() {
        lv = (ListView) findViewById(R.id.lv);
        txt_next = (TextView) findViewById(R.id.txt_next);

    }

    private void setOnclick() {


    }


}
