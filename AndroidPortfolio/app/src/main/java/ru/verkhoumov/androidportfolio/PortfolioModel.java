package ru.verkhoumov.androidportfolio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PortfolioModel {
    @SerializedName("category_link")
    @Expose
    private String categoryLink;

    @SerializedName("category_name")
    @Expose
    private String categoryName;

    @SerializedName("name")
    @Expose
    private String name;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("created")
    @Expose
    private String created;

    @SerializedName("text")
    @Expose
    private String text;

    @SerializedName("link")
    @Expose
    private String link;

    @SerializedName("image")
    @Expose
    private String image;

    @SerializedName("year")
    @Expose
    private String year;

    @SerializedName("finished")
    @Expose
    private String finished;

    @SerializedName("percent")
    @Expose
    private String percent;

    @SerializedName("progress")
    @Expose
    private String progress;

    @SerializedName("personal")
    @Expose
    private String personal;

    public String getCategoryLink() {
        return categoryLink;
    }

    public void setCategoryLink(String categoryLink) {
        this.categoryLink = categoryLink;
    }

    public String getCategoryName() {
        return "#" + categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
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

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
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

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getFinished() {
        return finished;
    }

    public void setFinished(String finished) {
        this.finished = finished;
    }

    public String getPercent() {
        return percent;
    }

    public void setPercent(String percent) {
        this.percent = percent;
    }

    public String getProgress() {
        return progress;
    }

    public void setProgress(String progress) {
        this.progress = progress;
    }

    public String getPersonal() {
        return personal;
    }

    public void setPersonal(String personal) {
        this.personal = personal;
    }
}