package ru.verkhoumov.androidportfolio;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class AboutFragment extends Fragment {
    RecyclerView recyclerView;
    List<AboutModel> abouts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_about, container, false);

        abouts = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        AboutAdapter adapter = new AboutAdapter(abouts, this);

        recyclerView = (RecyclerView) view.findViewById(R.id.aboutRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        App app = new App();
        app.getApi().getAboutData().enqueue(new Callback<List<AboutModel>>() {
            @Override
            public void onResponse(Call<List<AboutModel>> call, Response<List<AboutModel>> response) {
                abouts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<AboutModel>> call, Throwable t) {
                Toast
                        .makeText(getActivity(), "Connecting failed", Toast.LENGTH_LONG)
                        .show();

                t.printStackTrace();
            }
        });

        return view;
    }
}