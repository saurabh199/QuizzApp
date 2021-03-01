package com.proprofs.proprofsquizzes;

/**
 * Created by Shubham Jain on 09-07-2016.
 */
public class ListItem {
    private String quizTitle;
    private String description;
    private String Image;
    private Float rating;
    private String title;
    private String questions;
    private String relatedName;
    private String relatedImage;
    private String relatedTitle;
    private String featuredName;
    private String featuredImage;
    private String featuredTitle;
    private String startButton;

    private String user;

     /*  static String related = "related-name";
    String name = related.replaceAll("[^\\p{L}\\p{Z}]", "");

    static String image = "related-image";
    String images = image.replaceAll("[^\\p{L}\\p{Z}]", "");

    static String titles = "related-title";
    String rtitle = titles.replaceAll("[^\\p{L}\\p{Z}]", "");

    static String feature = "featured-name";
    String fnames = feature.replaceAll("[^\\p{L}\\p{Z}]", "");

    static String features = "featured-image";
    String fimage = features.replaceAll("[^\\p{L}\\p{Z}]", "");

    static String featuret = "featured-title";
    String ftitle = featuret.replaceAll("[^\\p{L}\\p{Z}]", "");*/

  //  static String button = "start-button";
   // String start = featuret.replaceAll("[^\\p{L}\\p{Z}]", "");

    public ListItem(String s, String string, String string1) {
    }

    public ListItem() {

    }


    public Float getRating() {
        return rating;
    }
    public void setRating(Float rating) {
        this.rating = rating;
    }

    public String getQuizTitle() {
        return quizTitle;
    }

    public void setQuizTitle(String quizTitle) {
        this.quizTitle = quizTitle;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String Image) {
        this.Image = Image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRelatedName() {
        return relatedName;
    }

    public void setRelatedName(String relatedName) {
        this.relatedName = relatedName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRelatedImage() {
        return relatedImage;
    }

    public void setRelatedImage(String relatedImage) {
        this.relatedImage = relatedImage;
    }

    public String getRelatedTitle() {
        return relatedTitle;
    }

    public void setRelatedTitle(String relatedTitle) {
        this.relatedTitle = relatedTitle;
    }

    public String getFeaturedName() {
        return featuredName;
    }

    public void setFeaturedName(String featuredName) {
        this.featuredName = featuredName;
    }

    public String getFeaturedImage() {
        return featuredImage;
    }

    public void setFeaturedImage(String featuredImage) {
        this.featuredImage = featuredImage;
    }


    public String getFeaturedTitle() {
        return featuredTitle;
    }

    public void setFeaturedTitle(String featuredTitle) {
        this.featuredTitle = featuredTitle;
    }

    public String getStartButton() {
        return startButton;
    }
    public void setStartButton(String startButton) {
        this.startButton = startButton;
    }

    public String getQuestions() {
        return questions;
    }
    public void setQuestions(String questions) {
        this.questions = questions;
    }


    public String getUser() {
        return user;
    }
    public void setUser(String user) {
        this.user = user;
    }
}