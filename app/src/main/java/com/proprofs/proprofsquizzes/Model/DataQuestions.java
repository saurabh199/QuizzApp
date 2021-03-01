package com.proprofs.proprofsquizzes.Model;

/**
 * Created by Avanish Singh on 17/08/2016.
 */
public class DataQuestions {

 String QuesImage,question,Type,option,AnsImage;
    int quizId,index,answerId;

    public DataQuestions() {

    }

    public String getAnsImage() {
        return AnsImage;
    }

    public void setAnsImage(String ansImage) {
        AnsImage = ansImage;
    }

    public int getAnswerId() {
        return answerId;
    }

    public void setAnswerId(int answerId) {
        this.answerId = answerId;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getOption() {
        return option;
    }

    public void setOption(String option) {
        this.option = option;
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

    public int getQuizId() {
        return quizId;
    }

    public void setQuizId(int quizId) {
        this.quizId = quizId;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
