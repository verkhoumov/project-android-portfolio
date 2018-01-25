package ru.verkhoumov.androidportfolio;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;
import java.util.List;

public class SkillsAdapter extends RecyclerView.Adapter<SkillsAdapter.ViewHolder> {
    private List<SkillsModel> skills;
    private EducationFragment educationFragment;

    public SkillsAdapter(List<SkillsModel> skills, EducationFragment educationFragment) {
        this.skills = skills;
        this.educationFragment = educationFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.skills_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SkillsModel post = skills.get(position);

        holder.name.setText(post.getName());
        holder.percent.setText(post.getPercent());
        holder.projects.setText(post.getProjects());

        new DownloadImageTask(holder.image).execute(post.getImage());
    }

    @Override
    public int getItemCount() {
        if (skills == null) {
            return 0;
        }

        return skills.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView name;
        TextView percent;
        TextView projects;
        ImageView image;

        public ViewHolder(View itemView) {
            super(itemView);

            name = (TextView) itemView.findViewById(R.id.skillsItemName);
            percent = (TextView) itemView.findViewById(R.id.skillsItemPercent);
            projects = (TextView) itemView.findViewById(R.id.skillsItemProjects);
            image = (ImageView) itemView.findViewById(R.id.skillsItemImage);
        }
    }

    // Загрузчик изображений.
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