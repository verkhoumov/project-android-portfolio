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

public class EducationFragment extends Fragment {
    RecyclerView educationRecyclerView;
    RecyclerView skillsRecyclerView;
    List<EducationModel> educations;
    List<SkillsModel> skills;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_education, container, false);

        educations = new ArrayList<>();
        skills = new ArrayList<>();

        LinearLayoutManager educationLayoutManager = new LinearLayoutManager(getContext());
        LinearLayoutManager skillsLayoutManager = new LinearLayoutManager(getContext());
        EducationAdapter educationAdapter = new EducationAdapter(educations, this);
        SkillsAdapter skillsAdapter = new SkillsAdapter(skills, this);

        educationRecyclerView = (RecyclerView) view.findViewById(R.id.educationRecyclerView);
        skillsRecyclerView = (RecyclerView) view.findViewById(R.id.skillsRecyclerView);

        educationRecyclerView.setNestedScrollingEnabled(false);
        skillsRecyclerView.setNestedScrollingEnabled(false);

        educationRecyclerView.setAdapter(educationAdapter);
        educationRecyclerView.setLayoutManager(educationLayoutManager);
        skillsRecyclerView.setAdapter(skillsAdapter);
        skillsRecyclerView.setLayoutManager(skillsLayoutManager);

        App app = new App();

        app.getApi().getEducationData().enqueue(new Callback<List<EducationModel>>() {
            @Override
            public void onResponse(Call<List<EducationModel>> call, Response<List<EducationModel>> response) {
                educations.addAll(response.body());
                educationRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<EducationModel>> call, Throwable t) {
                Toast
                        .makeText(getActivity(), "Connecting failed", Toast.LENGTH_LONG)
                        .show();

                t.printStackTrace();
            }
        });

        app.getApi().getSkillsData().enqueue(new Callback<List<SkillsModel>>() {
            @Override
            public void onResponse(Call<List<SkillsModel>> call, Response<List<SkillsModel>> response) {
                skills.addAll(response.body());
                skillsRecyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<SkillsModel>> call, Throwable t) {
                Toast
                        .makeText(getActivity(), "Connecting failed", Toast.LENGTH_LONG)
                        .show();

                t.printStackTrace();
            }
        });

        return view;
    }
}