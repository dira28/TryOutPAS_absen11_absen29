package com.example.ttyoutpas_absen11_absen29;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CountryResponse {
    @SerializedName("countries")
    private List<Country> countries;

    public List<Country> getCountries() {
        return countries;
    }
}