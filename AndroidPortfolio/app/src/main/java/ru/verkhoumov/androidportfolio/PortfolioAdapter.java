package ru.verkhoumov.androidportfolio;

import android.content.Context;
import android.content.Intent;
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

public class PortfolioAdapter extends RecyclerView.Adapter<PortfolioAdapter.ViewHolder> {
    private List<PortfolioModel> portfolio;
    private PortfolioFragment portfolioFragment;
    public Context mContext;

    public PortfolioAdapter(List<PortfolioModel> portfolio, PortfolioFragment portfolioFragment) {
        this.portfolio = portfolio;
        this.portfolioFragment = portfolioFragment;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.portfolio_item, parent, false);

        // Запоминаем контекст.
        mContext = parent.getContext();

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final PortfolioModel post = portfolio.get(position);

        if (position == 0) {
            holder.header.setVisibility(View.VISIBLE);
        }

        holder.categoryName.setText(post.getCategoryName());
        holder.finished.setText(post.getFinished());
        holder.name.setText(post.getName());

        new DownloadImageTask(holder.image).execute(post.getImage());

        holder.item.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Создание объекта Intent для вызова новой Activity.
                Intent intent = new Intent(mContext, DisplayProject.class);
                // Добавляем ключ -> значение.
                intent.putExtra("NAME", post.getName());
                intent.putExtra("IMAGE", post.getImage());
                intent.putExtra("DESCRIPTION", post.getDescription());
                intent.putExtra("STARTED", post.getCreated());
                intent.putExtra("FINISHED", post.getFinished());
                intent.putExtra("TEXT", post.getText());
                // Запуск новой Activity.
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (portfolio == null) {
            return 0;
        }

        return portfolio.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        TextView categoryName;
        TextView finished;
        ImageView image;
        TextView name;
        TextView header;
        View item;

        public ViewHolder(View itemView) {
            super(itemView);

            categoryName = (TextView) itemView.findViewById(R.id.portfolioItemType);
            finished = (TextView) itemView.findViewById(R.id.portfolioItemDate);
            image = (ImageView) itemView.findViewById(R.id.portfolioItemImage);
            name = (TextView) itemView.findViewById(R.id.portfolioItemName);
            header = (TextView) itemView.findViewById(R.id.portfolioItemDescription);
            item = itemView;
        }
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