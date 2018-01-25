package ru.verkhoumov.androidportfolio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SkillsModel {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("type")
    @Expose
    private String type;

    @SerializedName("code")
    @Expose
    private String code;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("percent")
    @Expose
    private String percent;

    @SerializedName("projects")
    @Expose
    private String projects;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("color")
    @Expose
    private String color;

    @SerializedName("position")
    @Expose
    private String position;

    @SerializedName("visible")
    @Expose
    private String visible;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPercent() {
        return percent + "%";
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getProjects() {
        return projects;
    }

    public void setProjects(String projects) {
        this.projects = projects;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public String getVisible() {
        return visible;
    }

    public void setVisible(String visible) {
        this.visible = visible;
    }
}