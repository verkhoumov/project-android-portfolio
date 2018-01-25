package ru.verkhoumov.androidportfolio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ProfileModel {
    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("birthday")
    @Expose
    private String birthday;

    @SerializedName("experience")
    @Expose
    private String experience;

    @SerializedName("skills_experience")
    @Expose
    private String skillsExperience;

    @SerializedName("skills")
    @Expose
    private String skills;

    @SerializedName("projects")
    @Expose
    private String projects;

    @SerializedName("profession")
    @Expose
    private String profession;

    @SerializedName("email")
    @Expose
    private String email;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("age")
    @Expose
    private String age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getExperience() {
        return experience;
    }

    public void setExperience(String experience) {
        this.experience = experience;
    }

    public String getSkillsExperience() {
        return skillsExperience;
    }

    public void setSkillsExperience(String skillsExperience) {
        this.skillsExperience = skillsExperience;
    }

    public String getSkills() {
        return skills;
    }

    public void setSkills(String skills) {
        this.skills = skills;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getProfession() {
        return profession;
    }

    public void setProfession(String profession) {
        this.profession = profession;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }
}