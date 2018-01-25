package ru.verkhoumov.androidportfolio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class VideoModel {
    @SerializedName("id")
    @Expose
    private String id;

    @SerializedName("title")
    @Expose
    private String title;

    @SerializedName("video")
    @Expose
    private String video;

    @SerializedName("preview")
    @Expose
    private String preview;

    @SerializedName("duration")
    @Expose
    private String duration;

    @SerializedName("created")
    @Expose
    private String created;

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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getVideo() {
        return video;
    }

    public void setVideo(String video) {
        this.video = video;
    }

    public String getPreview() {
        return preview;
    }

    public void setPreview(String preview) {
        this.preview = preview;
    }

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public String getCreated() {
        return created;
    }

    public void setCreated(String created) {
        this.created = created;
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