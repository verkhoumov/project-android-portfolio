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

public class EducationAdapter extends RecyclerView.Adapter<EducationAdapter.ViewHolder> {
    private List<EducationModel> educations;
    private EducationFragment educationFragment;

    public EducationAdapter(List<EducationModel> educations, EducationFragment educationFragment) {
        this.educations = educations;
        this.educationFragment = educationFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.education_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        EducationModel post = educations.get(position);

        holder.name.setText(post.getName());
        holder.faculty.setText(post.getFaculty());
        holder.city.setText(post.getCity());
        holder.specialization.setText(post.getSpecialization());
        holder.started.setText(post.getStarted());
        holder.finished.setText(post.getFinished());

        new DownloadImageTask(holder.image).execute(post.getImage());
    }

    @Override
    public int getItemCount() {
        if (educations == null) {
            return 0;
        }

        return educations.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        TextView name;
        TextView faculty;
        TextView city;
        TextView specialization;
        ImageView image;
        TextView started;
        TextView finished;

        public ViewHolder(View itemView) {
            super(itemView);

            title = (TextView) itemView.findViewById(R.id.titleEducation);
            name = (TextView) itemView.findViewById(R.id.educationItemName);
            faculty = (TextView) itemView.findViewById(R.id.educationItemFaculty);
            city = (TextView) itemView.findViewById(R.id.educationItemCity);
            specialization = (TextView) itemView.findViewById(R.id.educationItemSpecialization);
            image = (ImageView) itemView.findViewById(R.id.educationItemImage);
            started = (TextView) itemView.findViewById(R.id.educationItemPeriodStart);
            finished = (TextView) itemView.findViewById(R.id.educationItemPeriodEnd);
        }
    }

    //
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