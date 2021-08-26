package com.example.pawsome;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface dogApi {

    @GET("v1/breeds")
    Call<List<ModelClass>> getDogs();

   /* @GET("v1/breeds/search")
    Call<List<ModelClass>> getSearch();*/
}
