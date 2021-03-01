package com.proprofs.proprofsquizzes.Model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Sony on 9/17/2016.
 */
public class QuizResult
{
    private long quizStartTime;
    private long quizEndTime;

    private String quizId;
    private ArrayList<DataQuestionAnswer> list;
    private final String LogTag="QuizResult";

    public QuizResult()
    {
        this.list = new ArrayList<>();
    }

    public long getQuizStartTime() {
        return quizStartTime;
    }

    public void setQuizStartTime(long quizStartTime) {
        this.quizStartTime = quizStartTime;
    }

    public long getQuizEndTime() {
        return quizEndTime;
    }

    public void setQuizEndTime(long quizEndTime) {
        this.quizEndTime = quizEndTime;
    }

    public void insertDataInList(DataQuestionAnswer dataQuestionAnswer)
    {
        /*if(this.list.size() > 0)
        {
            for (DataQuestionAnswer obj: list) {
                if(obj.questionId != dataQuestionAnswer.questionId)
                {
                    list.add(dataQuestionAnswer);
                }
            }
        }
        else
        {*/
            this.list.add(dataQuestionAnswer);
        /*}*/

    }

    public ArrayList<DataQuestionAnswer> getList() {
        return list;
    }

    public String getQuizId() {
        return quizId;
    }

    public void setQuizId(String quizId) {
        this.quizId = quizId;
    }

    public JSONObject getResultInJsonFormat()
    {
        JSONObject jsonResponse=new JSONObject();
        try {

            jsonResponse.put("end",quizEndTime);
            jsonResponse.put("quizId",quizId);
            jsonResponse.put("start",quizStartTime);
            JSONArray data=new JSONArray();

            for (DataQuestionAnswer qa:list)
            {
                JSONObject singleArrayItem=new JSONObject();
                JSONArray answers=new JSONArray();
                singleArrayItem.put("question",qa.questionId);
                for (String ans:qa.answerIds)
                {
                    answers.put(ans);
                }
                singleArrayItem.put("answer",answers);
                data.put(singleArrayItem);
            }
            jsonResponse.put("data",data);
        } catch (JSONException e)
        {
            e.printStackTrace();
        }
        catch (ArrayIndexOutOfBoundsException e)
        {
            Log.d(LogTag,jsonResponse.toString());
            return jsonResponse;
        }
        Log.d(LogTag,jsonResponse.toString());
        return jsonResponse;
    }
}
