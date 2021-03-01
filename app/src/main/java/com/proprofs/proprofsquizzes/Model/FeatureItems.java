package com.proprofs.proprofsquizzes.Model;

import android.os.Parcel;
import android.os.Parcelable;

import com.proprofs.proprofsquizzes.ParseResponse;

import java.util.ArrayList;


public class FeatureItems implements Parcelable {
        public String Question,QuestionImageUrl,QuestionId;
         ArrayList<ParseResponse.FeaturedBean> MyKeys;
        // public ArrayList<ParseResponse.RelatedBean> RelatedKey;
       // public String RelatedName,RelatedImage,RelatedTitle;
        public String featuredName,featuredImage,featuredTitle;
        public String Type;
        public int index;


        public FeatureItems(String featuredName, String featuredImage, String featuredTitle, ArrayList<ParseResponse.FeaturedBean>
                myKeys)
        {
            featuredName = featuredName;
            featuredImage = featuredImage;
            featuredTitle = featuredTitle;
            MyKeys = myKeys;

        }
        /*  public QuizItem(String relatedName, String relatedImage, String relatedTitle, ArrayList<ParseResponse.RelatedBean>
                  relatedKey)
          {
              RelatedName = relatedName;
              RelatedImage = relatedImage;
              RelatedTitle = relatedTitle;
              RelatedKey = relatedKey;

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
        public FeatureItems(String featuredName, String featuredImage, String relatedTitle) {

        }

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeString(this.featuredName);
            dest.writeString(this.featuredImage);
            dest.writeString(this.featuredTitle);
            dest.writeList(this.MyKeys);
      /*  dest.writeString(this.RelatedName);
        dest.writeString(this.RelatedImage);
        dest.writeString(this.RelatedTitle);
        dest.writeString(String.valueOf(this.RelatedKey));*/
        }

        public FeatureItems(Parcel in) {
            this.featuredName = in.readString();
            this.featuredImage = in.readString();
            this.featuredTitle = in.readString();
            this.MyKeys = new ArrayList<ParseResponse.FeaturedBean>();
            in.readList(this.MyKeys, ParseResponse.QuizBean.KeysBean.class.getClassLoader());

      /*  this.RelatedName = in.readString();
        this.RelatedImage = in.readString();
        this.RelatedTitle = in.readString();
        this.RelatedKey = new ArrayList<ParseResponse.RelatedBean>();
        in.readList(this.RelatedKey,ParseResponse.RelatedBean.class.getClassLoader());*/
        }

        public static final Creator<FeatureItems> CREATOR = new Creator<FeatureItems>() {
            @Override
            public FeatureItems createFromParcel(Parcel source) {
                return new FeatureItems(source);
            }

            @Override
            public FeatureItems[] newArray(int size) {
                return new FeatureItems[size];
            }
        };
    }


