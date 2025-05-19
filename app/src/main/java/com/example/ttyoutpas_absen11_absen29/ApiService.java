package com.example.ttyoutpas_absen11_absen29;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("all_countries.php")
    Call<CountryResponse> getCountries();
}