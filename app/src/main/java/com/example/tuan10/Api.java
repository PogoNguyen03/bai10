package com.example.tuan10;
import  java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface Api {
    String BASE_URL = "https://raw.githubusercontent.com/PogoNguyen03/productnew/main/";

    @GET("getlist")
    Call<List<Season>> getSeasons();
}
