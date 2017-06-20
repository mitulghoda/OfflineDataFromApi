package com.offlinedata;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
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

public class MainActivity extends AppCompatActivity {

    ListView lv;
    TextView txt_next;
    List<ListResoponse> listResoponses;
    ListAdapter listAdapter;
    DatabaseHandler db ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        idMapping();
        db = new DatabaseHandler(this);

        callApi();
        setOnclick();
    }

    private void callApi() {
        ApiHandler.getApi().getAllData(getMap(), new Callback<MainResponse>() {
            @Override
            public void success(MainResponse mainResponse, Response response) {

                if(mainResponse ==null){
                    return;
                }
                if(!mainResponse.getStatus().equalsIgnoreCase("success")){
                    return;
                }
                if(mainResponse.getResult()==null){
                    return;
                }
                if(mainResponse.getResult().isEmpty()){
                    return;
                }
                if(mainResponse.getStatus().equalsIgnoreCase("success")){

                    listResoponses = mainResponse.getResult();
                    listAdapter = new ListAdapter(MainActivity.this,listResoponses);
                    lv.setAdapter(listAdapter);
                    db.delete();
                    for(int i =0;i<listResoponses.size();i++){
                        if(i==0){
                            db.addContact(new Contact(""+listResoponses.get(i).getFirstName(), "http://www.gmm.srl/wp-content/uploads/Logo-G.jpg", ""+listResoponses.get(i).getClientId()));


                        }
                        else {
                            db.addContact(new Contact(""+listResoponses.get(i).getFirstName(), ""+listResoponses.get(i).getProfilePic(), ""+listResoponses.get(i).getClientId()));

                        }
                    }

                    List<Contact> contacts = db.getAllContacts();
                    Log.e("si",""+contacts.size());





                }
            }

            @Override
            public void failure(RetrofitError error) {

            }
        });
    }

    private void idMapping() {
        lv = (ListView)findViewById(R.id.lv);
        txt_next = (TextView)findViewById(R.id.txt_next);

    }
    private void setOnclick()
    {
        txt_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent i = new Intent(MainActivity.this,DatabaseActivity.class);
                startActivity(i);
            }
        });
    }

    private Map<String,String> getMap(){

        Map<String,String> map = new HashMap<>();

        map.put("trainer_id","95");
        return map;
    }
}
