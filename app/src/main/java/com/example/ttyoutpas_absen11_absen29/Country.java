package com.example.ttyoutpas_absen11_absen29;

import com.google.gson.annotations.SerializedName;

public class Country {
    @SerializedName("name_en")
    private String name;

    @SerializedName("flag_url_32")
    private String flagUrl;

    public Country(String name, String flagUrl) {
        this.name = name;
        this.flagUrl = flagUrl;
    }

    public String getName() {
        return name;
    }

    public String getFlagUrl() {
        return flagUrl;
    }
}