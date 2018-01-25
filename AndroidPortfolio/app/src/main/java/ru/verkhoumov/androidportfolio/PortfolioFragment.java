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

public class PortfolioFragment extends Fragment {
    RecyclerView recyclerView;
    List<PortfolioModel> portfolio;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_portfolio, container, false);

        portfolio = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        PortfolioAdapter adapter = new PortfolioAdapter(portfolio, this);

        recyclerView = (RecyclerView) view.findViewById(R.id.portfolioRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        App app = new App();
        app.getApi().getPortfolioData().enqueue(new Callback<List<PortfolioModel>>() {
            @Override
            public void onResponse(Call<List<PortfolioModel>> call, Response<List<PortfolioModel>> response) {
                portfolio.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<PortfolioModel>> call, Throwable t) {
                Toast
                        .makeText(getActivity(), "Connecting failed", Toast.LENGTH_LONG)
                        .show();

                t.printStackTrace();
            }
        });

        return view;
    }
}