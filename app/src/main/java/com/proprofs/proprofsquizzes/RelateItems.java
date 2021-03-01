package com.proprofs.proprofsquizzes;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

/**
 * Created by Shubham Jain on 10-11-2016.
 */

public class RelateItems implements Parcelable{
    public String relatedName,relatedImage,relatedTitle,featuredName,featuredImage,featuredTitle;
    public ArrayList<ParseResponse.RelatedBean> MyKey;
    public RelateItems(String relatedName, String relatedImage, String relatedTitle, ArrayList<ParseResponse.RelatedBean>
            MyKey)
    {
        relatedName = relatedName;
        relatedImage = relatedImage;
        relatedTitle = relatedTitle;
        MyKey = MyKey;

    }
    public RelateItems(ParseResponse.RelatedBean relatedName, String relatedImage, String relatedTitle) {

    }

    public static final Creator<RelateItems> CREATOR = new Creator<RelateItems>() {
        @Override
        public RelateItems createFromParcel(Parcel in) {
            return new RelateItems(in);
        }

        @Override
        public RelateItems[] newArray(int size) {
            return new RelateItems[size];
        }
    };

    public RelateItems(String relatedName, String relatedImage, String relatedTitle) {

    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.relatedName);
        dest.writeString(this.relatedImage);
        dest.writeString(this.relatedTitle);
        dest.writeString(String.valueOf(this.MyKey));
    }
    public RelateItems(Parcel in) {
        this.relatedName = in.readString();
        this.relatedImage = in.readString();
        this.relatedTitle = in.readString();
        this.MyKey = new ArrayList<ParseResponse.RelatedBean>();
        in.readList(this.MyKey,ParseResponse.RelatedBean.class.getClassLoader());
    }
    }

