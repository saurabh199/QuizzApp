package com.proprofs.proprofsquizzes.Model;

/**
 * Created by Sony on 9/18/2016.
 */
public class ResponseData {

   int id;
    String desc,title,image;


    public ResponseData(int id, String desc, String title, String image) {
        this.id = id;
        this.desc = desc;
        this.title = title;
        this.image = image;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
