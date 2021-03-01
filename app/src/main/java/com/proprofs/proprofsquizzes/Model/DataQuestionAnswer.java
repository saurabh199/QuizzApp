package com.proprofs.proprofsquizzes.Model;

/**
 * Created by Sony on 9/17/2016.
 */
public class DataQuestionAnswer
{
    public String questionId;
    public String answerIds[];

    public DataQuestionAnswer(String questionId, String... answerIds)
    {
        this.questionId = questionId;
        this.answerIds = answerIds;
    }
}
