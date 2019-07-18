package com.example.akustress;

import android.os.Parcel;
import android.os.Parcelable;

public class Movie implements Parcelable {
    private String titleFilm;
    private String dateFilm;
    private String descFilm;
    private String rateFilm;
    private int posterFilm;

    public String getTitleFilm() {
        return titleFilm;
    }

    public void setTitleFilm(String titleFilm) {
        this.titleFilm = titleFilm;
    }

    public String getDateFilm() {
        return dateFilm;
    }

    public void setDateFilm(String dateFilm) {
        this.dateFilm = dateFilm;
    }

    public String getDescFilm() {
        return descFilm;
    }

    public void setDescFilm(String descFilm) {
        this.descFilm = descFilm;
    }

    public String getRateFilm() {
        return rateFilm;
    }

    public void setRateFilm(String rateFilm) {
        this.rateFilm = rateFilm;
    }

    public int getPosterFilm() {
        return posterFilm;
    }

    public void setPosterFilm(int posterFilm) {
        this.posterFilm = posterFilm;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleFilm);
        dest.writeString(this.dateFilm);
        dest.writeString(this.descFilm);
        dest.writeString(this.rateFilm);
        dest.writeInt(this.posterFilm);
    }

    public Movie() {
    }

    protected Movie(Parcel in) {
        this.titleFilm = in.readString();
        this.dateFilm = in.readString();
        this.descFilm = in.readString();
        this.rateFilm = in.readString();
        this.posterFilm = in.readInt();
    }

    public static final Parcelable.Creator<Movie> CREATOR = new Parcelable.Creator<Movie>() {
        @Override
        public Movie createFromParcel(Parcel source) {
            return new Movie(source);
        }

        @Override
        public Movie[] newArray(int size) {
            return new Movie[size];
        }
    };
}
