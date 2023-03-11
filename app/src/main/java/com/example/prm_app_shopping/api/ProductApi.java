package com.example.prm_app_shopping.api;

import com.example.prm_app_shopping.model.Product;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface ProductApi {
    Gson gson = new GsonBuilder()
            .setDateFormat("yyyy-mm-dd hh:MM:ss")
            .create();

    ProductApi productApi = new Retrofit.Builder()
            .baseUrl("https://64085ddf8ee73db92e3eafad.mockapi.io/api/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ProductApi.class);

    @GET("products")
    Call<List<Product>> getAllProduct();

    @GET("products")
    Call<List<Product>> getAllProductByBrand(@Query("brand_id") String productTypeId);

    @GET("products/{id}")
    Call<Product> getProductById(@Path("id") int id);

    @GET("products")
    Call<List<Product>> getAllProductByTypeWithPaging(
            @Query("brand_id") String productTypeId,
            @Query("page") int page,
            @Query("limit") int limit );


    @GET("products")
    Call<List<Product>> getAllProductWithPaging(
            @Query("page") int page,
            @Query("limit") int limit );
}
