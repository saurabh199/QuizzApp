package com.proprofs.proprofsquizzes.Model;

import java.util.ArrayList;

/**
 * Created by Avanish Singh on 24/08/2016.
 */
public class Quiz {

    String quizId;
    public String QuesImage;
    public   String question;
    String questionId;
    String Type;
    int index;
    String rating;
  public  ArrayList<Keys> keysList;

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public ArrayList<Keys> getKeysList() {
        return keysList;
    }

    public void setKeysList(ArrayList<Keys> keysList) {
        this.keysList = keysList;
    }

    public String getQuesImage() {
        return QuesImage;
    }

    public void setQuesImage(String quesImage) {
        QuesImage = quesImage;
    }

    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    public String getQuestionId() {
        return questionId;
    }

    public void setQuestionId(String questionId) {
        this.questionId = questionId;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }
}
