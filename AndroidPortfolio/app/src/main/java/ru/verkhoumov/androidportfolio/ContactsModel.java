package ru.verkhoumov.androidportfolio;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ContactsModel {
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

    @SerializedName("link")
    @Expose
    private String link;

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

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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