package ru.verkhoumov.androidportfolio;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    // Обо мне.
    @GET("/api/profile/get")
    Call<ProfileModel> getProfileData();

    // Обо мне.
    @GET("/api/about/get")
    Call<List<AboutModel>> getAboutData();

    // Образование.
    @GET("/api/education/get")
    Call<List<EducationModel>> getEducationData();

    // Навыки.
    @GET("/api/skills/get")
    Call<List<SkillsModel>> getSkillsData();

    // Проекты.
    @GET("/api/portfolio/get")
    Call<List<PortfolioModel>> getPortfolioData();

    // Контакты.
    @GET("/api/contacts/get")
    Call<List<ContactsModel>> getContactsData();
}
