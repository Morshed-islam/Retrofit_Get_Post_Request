package com.techmorshed.simplegetrequest;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.techmorshed.simplegetrequest.API.RetrofitAp;
import com.techmorshed.simplegetrequest.API.RetrofitData;
import com.techmorshed.simplegetrequest.adapter.MyListAdapter;
import com.techmorshed.simplegetrequest.model.Network;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;

public class Main2Activity extends AppCompatActivity {

    List<Network.Image> list;
    MyListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        final ListView listView = (ListView) findViewById(R.id.list_item);

        list = new ArrayList<>();

        RetrofitAp api = RetrofitData.getRetrofit().create(RetrofitAp.class);
        Call<Network> call = api.getImageData();

        call.enqueue(new retrofit2.Callback<Network>() {
            @Override
            public void onResponse(Call<Network> call, retrofit2.Response<Network> response) {

                if (response.isSuccessful()){

                    list = response.body().getImages();

                    adapter = new MyListAdapter(Main2Activity.this,list);
                    listView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<Network> call, Throwable t) {
                Log.d("tag",t.getMessage());
            }
        });
    }
}