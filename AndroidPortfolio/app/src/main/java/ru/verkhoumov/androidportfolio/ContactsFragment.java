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


public class ContactsFragment extends Fragment {
    RecyclerView recyclerView;
    List<ContactsModel> contacts;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contacts, container, false);

        contacts = new ArrayList<>();

        LinearLayoutManager layoutManager = new LinearLayoutManager(getContext());
        ContactsAdapter adapter = new ContactsAdapter(contacts, this);

        recyclerView = (RecyclerView) view.findViewById(R.id.contactsRecyclerView);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);

        recyclerView.setNestedScrollingEnabled(false);

        App app = new App();
        app.getApi().getContactsData().enqueue(new Callback<List<ContactsModel>>() {
            @Override
            public void onResponse(Call<List<ContactsModel>> call, Response<List<ContactsModel>> response) {
                contacts.addAll(response.body());
                recyclerView.getAdapter().notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<List<ContactsModel>> call, Throwable t) {
                Toast
                        .makeText(getActivity(), "Connecting failed", Toast.LENGTH_LONG)
                        .show();

                t.printStackTrace();
            }
        });

        return view;
    }
}
