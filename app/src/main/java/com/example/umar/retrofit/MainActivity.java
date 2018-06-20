package com.example.umar.retrofit;


import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends Activity {
    private RetrofitClient apiInterface;
    ArrayList<Technicians> own;
    private RecyclerView recyclerView;
    private RecyclerAdapter adapter;
    ListView list;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        own = new ArrayList<>();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setHasFixedSize(true);


// getting values from api

        apiInterface = GetRetrofit.getRetrofit().create(RetrofitClient.class);
        Call<List<Technicians>> cal = apiInterface.getLostThings();
        RetrofitClient apiInterface = GetRetrofit.getRetrofit().create(RetrofitClient.class);
        cal.enqueue(new Callback<List<Technicians>>() {
            @Override
            public void onResponse(Call<List<Technicians>> call, Response<List<Technicians>> response) {
                List<Technicians> list = response.body();
                if (response.isSuccessful()) {
                    for (Technicians x : list) {
                        own.add(x);
                    }
                    Toast.makeText(MainActivity.this, "connection successfull", Toast.LENGTH_SHORT).show();
                    Log.d("MTAG", "onResponse: is successfully: " + response.body());

                    adapter = new RecyclerAdapter(own);
                    recyclerView.setAdapter(adapter);
                }

            }

            @Override
            public void onFailure(Call<List<Technicians>> call, Throwable t) {
                Log.d("MTAG", "onResponse: is Fail " + t.getLocalizedMessage());
                Toast.makeText(MainActivity.this, "connection fail", Toast.LENGTH_SHORT).show();
            }
        });

    }

}
