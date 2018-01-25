package ru.verkhoumov.androidportfolio;

import android.os.Build;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class AboutAdapter extends RecyclerView.Adapter<AboutAdapter.ViewHolder> {
    private List<AboutModel> abouts;
    private AboutFragment aboutFragment;

    public AboutAdapter(List<AboutModel> abouts, AboutFragment aboutFragment) {
        this.abouts = abouts;
        this.aboutFragment = aboutFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.about_item, parent, false);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        AboutModel post = abouts.get(position);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            holder.text.setText(Html.fromHtml(post.getText(), Html.FROM_HTML_MODE_LEGACY));
        } else {
            holder.text.setText(Html.fromHtml(post.getText()));
        }

        holder.year.setText(post.getYear());
    }

    @Override
    public int getItemCount() {
        if (abouts == null) {
            return 0;
        }

        return abouts.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView text;
        TextView year;

        public ViewHolder(View itemView) {
            super(itemView);

            text = (TextView) itemView.findViewById(R.id.aboutItem_Text);
            year = (TextView) itemView.findViewById(R.id.aboutItem_Year);
        }
    }
}