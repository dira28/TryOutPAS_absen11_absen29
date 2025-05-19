package com.example.ttyoutpas_absen11_absen29;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.example.ttyoutpas_absen11_absen29.ApiService;
import com.example.ttyoutpas_absen11_absen29.MainActivity;
import com.example.ttyoutpas_absen11_absen29.R;
import com.example.ttyoutpas_absen11_absen29.CountryAdapter;
import com.example.ttyoutpas_absen11_absen29.CountryResponse;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CountryFragment extends Fragment {

    private RecyclerView recyclerView;
    private ProgressBar progressBar;
    private CountryAdapter adapter;

    private ApiService apiService;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater,
                             @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_country, container, false);
        recyclerView = view.findViewById(R.id.recyclerViewCountry);
        progressBar = view.findViewById(R.id.progressBarCountry);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        apiService = MainActivity.apiService;

        loadCountries();

        return view;
    }

    private void loadCountries() {
        progressBar.setVisibility(View.VISIBLE);
        apiService.getCountries().enqueue(new Callback<CountryResponse>() {
            @Override
            public void onResponse(Call<CountryResponse> call, Response<CountryResponse> response) {
                progressBar.setVisibility(View.GONE);
                if (response.isSuccessful() && response.body() != null) {
                    Log.d("CountryFragment", "Response: " + new Gson().toJson(response.body()));

                    adapter = new CountryAdapter(getContext(), response.body().getCountries());
                    recyclerView.setAdapter(adapter);
                } else {
                    Toast.makeText(getContext(), "Gagal mengambil data", Toast.LENGTH_SHORT).show();
                    Log.e("CountryFragment", "Response error: " + response.message());
                }
            }

            @Override
            public void onFailure(Call<CountryResponse> call, Throwable t) {
                progressBar.setVisibility(View.GONE);
                Toast.makeText(getContext(), "Error: " + t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("CountryFragment", "Failure: ", t);
            }
        });
    }
}

