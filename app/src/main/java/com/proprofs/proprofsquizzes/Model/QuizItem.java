package com.proprofs.proprofsquizzes.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.proprofs.proprofsquizzes.ParseResponse;

import java.util.ArrayList;

/**
 * Created by Sony on 9/18/2016.
 */
public class QuizItem implements Parcelable {
    public String Question,QuestionImageUrl,QuestionId;
    public ArrayList<ParseResponse.QuizBean.KeysBean> MyKeys;
    public ArrayList<ParseResponse.RelatedBean> RelateKey;
    public String RelatedName,RelatedImage,RelatedTitle;
    public String featuredName,featuredImage,featuredTitle;
    public String answerId,option,AnsImage;
    public String Type;
    public int index;

    public QuizItem(String question, String questionImageUrl, String questionId, ArrayList<ParseResponse.QuizBean.KeysBean>
            myKeys, String type, int index)
   {
        Question = question;
        QuestionImageUrl = questionImageUrl;
        QuestionId = questionId;
        MyKeys = myKeys;
        Type = type;
        this.index = index;
    }
  public QuizItem(String relatedName, String relatedImage, String relatedTitle, ArrayList<ParseResponse.RelatedBean>
            relateKey)
    {
        RelatedName = relatedName;
        RelatedImage = relatedImage;
        RelatedTitle = relatedTitle;
        RelateKey = relateKey;
    }


    /*public QuizItem(String answerId, String option, String AnsImage)
    {
        this.answerId = answerId;
        this.option = option;
        this.AnsImage = AnsImage;

    }*/
  /*  public QuizItem(String RelatedName, String relatedImage, String relatedTitle, ArrayList<ParseResponse.RelatedBean>
            relatedKey)
    {
        RelatedName = relatedName;
        QuestionImageUrl = relatedImage;
        QuestionId = relatedTitle;
        MyKeys = myKeys;
        Type = type;
        this.index = index;
    }*/
    public QuizItem(String relatedName, String relatedImage, String relatedTitle) {
    }
    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        try {
            dest.writeString(this.Question);
            dest.writeString(this.QuestionImageUrl);
            dest.writeString(this.QuestionId);
            dest.writeList(this.MyKeys);
            dest.writeString(this.Type);
            dest.writeInt(this.index);
            dest.writeString(this.RelatedName);
            dest.writeString(this.RelatedImage);
            dest.writeString(this.RelatedTitle);
            dest.writeString(this.answerId);
            dest.writeString(this.option);
            dest.writeString(this.AnsImage);
        } catch (Exception e){
            e.getStackTrace();
        }
      /*  dest.writeString(this.RelatedName);
        dest.writeString(this.RelatedImage);
        dest.writeString(this.RelatedTitle);
        dest.writeString(String.valueOf(this.RelatedKey));*/
    }

    public QuizItem(Parcel in) {
        this.Question = in.readString();
        this.QuestionImageUrl = in.readString();
        this.QuestionId = in.readString();
        this.MyKeys = new ArrayList<ParseResponse.QuizBean.KeysBean>();
        in.readList(this.MyKeys, ParseResponse.QuizBean.KeysBean.class.getClassLoader());
        this.Type = in.readString();
        this.index = in.readInt();
        this.RelatedName = in.readString();
        this.RelatedImage = in.readString();
        this.RelatedTitle = in.readString();
        this.answerId = in.readString();
        this.option = in.readString();
        this.AnsImage = in.readString();
      /*  this.RelatedName = in.readString();
        this.RelatedImage = in.readString();
        this.RelatedTitle = in.readString();
        this.RelatedKey = new ArrayList<ParseResponse.RelatedBean>();
        in.readList(this.RelatedKey,ParseResponse.RelatedBean.class.getClassLoader());*/
    }

    public static final Creator<QuizItem> CREATOR = new Creator<QuizItem>() {
        @Override
        public QuizItem createFromParcel(Parcel source) {
            return new QuizItem(source);
        }

        @Override
        public QuizItem[] newArray(int size) {
            return new QuizItem[size];
        }
    };
}
