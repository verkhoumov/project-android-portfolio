package ru.verkhoumov.androidportfolio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainFragment extends Fragment {
    ProfileModel profile;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_main, container, false);

        final TextView name = (TextView) view.findViewById(R.id.profileName);
        final TextView about = (TextView) view.findViewById(R.id.profileAbout);
        final TextView city = (TextView) view.findViewById(R.id.profileCity);
        final TextView old = (TextView) view.findViewById(R.id.profileOld);
        final TextView experience = (TextView) view.findViewById(R.id.profileExperience);
        final TextView projects = (TextView) view.findViewById(R.id.profileProjects);
        final ImageView image = (ImageView) view.findViewById(R.id.profileImage);

        App app = new App();
        app.getApi().getProfileData().enqueue(new Callback<ProfileModel>() {
            @Override
            public void onResponse(Call<ProfileModel> call, Response<ProfileModel> response) {
                profile = response.body();

                name.setText(profile.getName());
                about.setText(profile.getProfession());
                city.setText(profile.getCity());
                old.setText(profile.getAge());
                experience.setText(profile.getExperience());
                projects.setText(profile.getProjects());

                new DownloadImageTask(image).execute(profile.getImage());
            }

            @Override
            public void onFailure(Call<ProfileModel> call, Throwable t) {
                Toast
                        .makeText(getActivity(), "Connecting failed", Toast.LENGTH_LONG)
                        .show();

                t.printStackTrace();
            }
        });

        return view;
    }

    private class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {
        ImageView bmImage;

        public DownloadImageTask(ImageView bmImage) {
            this.bmImage = bmImage;
        }

        protected Bitmap doInBackground(String... urls) {
            String urldisplay = urls[0];
            Bitmap mIcon11 = null;
            try {
                InputStream in = new java.net.URL(urldisplay).openStream();
                mIcon11 = BitmapFactory.decodeStream(in);
            } catch (Exception e) {
                Log.e("Error", e.getMessage());
                e.printStackTrace();
            }
            return mIcon11;
        }

        protected void onPostExecute(Bitmap result) {
            bmImage.setImageBitmap(result);
        }
    }
}