package com.example.moviecatalogue2;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String dataTitle;
    private String dataDesc;
    private String dataDate;
    private int dataPoster;
    private int dataBackdrop;



    protected Movie(Parcel in) {
        dataTitle = in.readString();
        dataDesc = in.readString();
        dataDate = in.readString();
        dataPoster = in.readInt();
        dataBackdrop =in.readInt();
    }

    public static final Creator<Movie> CREATOR = new Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel in) {
            return new Movie(in);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };

    public Movie() {

    }
    public int getBackdrop() {
        return dataBackdrop;
    }

    public void setBackdrop(int backdrop) {
        dataBackdrop = backdrop;
    }

    public String getTitle() {
        return dataTitle;
    }

    public void setTitle(String title) {
        dataTitle = title;
    }

    public String getDesc() {
        return dataDesc;
    }

    public void setDesc(String desc) {
        dataDesc = desc;
    }


    public String getDate() {
        return dataDate;
    }

    public void setDate(String date) {
        dataDate = date;
    }

    public int getPoster() {
        return dataPoster;
    }

    public void setPoster(int poster) {
        dataPoster = poster;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(dataTitle);
        dest.writeString(dataDesc);
        dest.writeString(dataDate);
        dest.writeInt(dataPoster);
        dest.writeInt(dataBackdrop);
    }
}
