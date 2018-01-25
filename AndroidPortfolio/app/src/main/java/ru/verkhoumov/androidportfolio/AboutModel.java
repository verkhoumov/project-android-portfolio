package ru.verkhoumov.androidportfolio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class AboutModel {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("year")
    @Expose
    private String year;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("visible")
    @Expose
    private String visible;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }
}