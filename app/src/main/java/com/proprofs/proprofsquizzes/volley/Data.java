package com.proprofs.proprofsquizzes.volley;

/**
 * Created by Avanish Singh on 04/07/2016.
 */
public class Data {


    private String imageUrl;
    private String title;
    private String description;
    private String categoryName;
    private String urlTitle;
    private String name;
    static String login = "user-login";
    String user = login.replaceAll("[^\\p{L}\\p{Z}]", "");
    public Data() {
    }
    public Data(String imageUrl, String title, String description, String name
    ) {
        this.title = title;
        this.imageUrl = imageUrl;
        this.description = description;
        this.name = name;
        this.user = user;
    }
    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getUrlTitle() {
        return urlTitle;
    }

    public void setUrlTitle(String urlTitle) {
        this.urlTitle = urlTitle;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategoryName() {
        return categoryName;
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
}
