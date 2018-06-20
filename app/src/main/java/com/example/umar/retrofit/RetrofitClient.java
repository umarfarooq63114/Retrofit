package com.example.umar.retrofit;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;

public interface RetrofitClient
{
    @GET("technicians")
    Call<List<Technicians>> getLostThings();
}
