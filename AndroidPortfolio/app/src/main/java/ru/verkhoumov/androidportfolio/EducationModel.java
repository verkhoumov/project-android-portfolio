package ru.verkhoumov.androidportfolio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class EducationModel {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("faculty")
    @Expose
    private String faculty;

    @SerializedName("city")
    @Expose
    private String city;

    @SerializedName("specialization")
    @Expose
    private String specialization;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("started")
    @Expose
    private String started;

    @SerializedName("finished")
    @Expose
    private String finished;

    @SerializedName("visible")
    @Expose
    private String visible;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFaculty() {
        return faculty;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getStarted() {
        return started;
    }

    public void setStarted(String started) {
        this.started = started;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }
}