package ru.verkhoumov.androidportfolio;

import android.app.Application;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class App extends Application {
    private ApiInterface apiInterface;

    public App() {
        Retrofit retrofit = new Retrofit.Builder()
                // Основная часть адреса.
                .baseUrl("http://verkhoumov.ru/")
                // Конвертер для преобразования JSON-данных в объекты.
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        // Объект для выполнения запросов к API.
        apiInterface = retrofit.create(ApiInterface.class);
    }

    public ApiInterface getApi() {
        return apiInterface;
    }
}
