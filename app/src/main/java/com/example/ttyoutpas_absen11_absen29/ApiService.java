package com.example.ttyoutpas_absen11_absen29;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface ApiService {
    @GET("all_countries.php")
    Call<CountryResponse> getCountries();

    @GET("eventslast.php")
    Call<MatchResponse> getLastEvents(@Query("id") String teamId);
}