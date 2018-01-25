package ru.verkhoumov.androidportfolio;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Html;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.InputStream;

public class DisplayProject extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.project_info);
        setTitle("Информация о проекте");

        // Показываем кнопку "Назад".
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        Intent intent = getIntent();

        // Получаем данные из объекта Intent.
        String name = intent.getStringExtra("NAME");
        String image = intent.getStringExtra("IMAGE");
        String description = intent.getStringExtra("DESCRIPTION");
        String text = intent.getStringExtra("TEXT");
        String started = intent.getStringExtra("STARTED");
        String finished = intent.getStringExtra("FINISHED");

        // Создание текстового поля.
        TextView projectName = (TextView) findViewById(R.id.projectInfoName);
        TextView projectStarted = (TextView) findViewById(R.id.projectInfoStarted);
        TextView projectFinished = (TextView) findViewById(R.id.projectInfoFinished);
        TextView projectDescription = (TextView) findViewById(R.id.projectInfoDescription);
        TextView projectText = (TextView) findViewById(R.id.projectInfoText);
        ImageView projectImage = (ImageView) findViewById(R.id.projectInfoImage);

        // Загружаем картинку.
        new DownloadImageTask(projectImage).execute(image);

        // Подставляем контент.
        projectName.setText(name);
        projectStarted.setText(started);

        if (finished != null) {
            projectFinished.setText(finished);
        } else {
            projectFinished.setVisibility(View.GONE);
        }

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            projectDescription.setText(Html.fromHtml(description, Html.FROM_HTML_MODE_LEGACY));

            if (text != null) {
                projectText.setText(Html.fromHtml(text, Html.FROM_HTML_MODE_LEGACY));
            }
        } else {
            projectDescription.setText(Html.fromHtml(description));

            if (text != null) {
                projectText.setText(Html.fromHtml(text));
            }
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            finish();
        }

        return super.onOptionsItemSelected(item);
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
            result = ImageHelper.getRoundedCornerBitmap(result, 6);
            bmImage.setImageBitmap(result);
        }
    }
}