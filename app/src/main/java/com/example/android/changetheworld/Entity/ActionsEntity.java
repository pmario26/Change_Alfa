package com.example.android.changetheworld.Entity;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

/**
 * Created by pmario on 13/12/17.
 */

public class ActionsEntity implements Serializable {
   // @SerializedName("id")
   //@Expose
    private Long id;

    //@SerializedName("name")
    //@Expose
    private String name;

    //@SerializedName("image")
    //@Expose
    private String image;

    @SerializedName("description")
    @Expose
    private String description;

    public ActionsEntity(Long id, String name, String image, String description, String site) {
        this.id = id;
        this.name = name;
        this.image = image;
        this.description = description;
        this.site = site;
    }

    @SerializedName("site")
    @Expose
    private String site;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getImage() {
        return image;
    }

    public String getDescription() {
        return description;
    }

    public String getSite() {
        return site;
    }
}
