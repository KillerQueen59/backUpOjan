package com.example.akustress;

import android.os.Parcel;
import android.os.Parcelable;

public class TvShow implements Parcelable {
    private String titleTv;
    private String dateTv;
    private String descTv;
    private String rateTv;

    public String getTitleTv() {
        return titleTv;
    }

    public void setTitleTv(String titleTv) {
        this.titleTv = titleTv;
    }

    public String getDateTv() {
        return dateTv;
    }

    public void setDateTv(String dateTv) {
        this.dateTv = dateTv;
    }

    public String getDescTv() {
        return descTv;
    }

    public void setDescTv(String descTv) {
        this.descTv = descTv;
    }

    public String getRateTv() {
        return rateTv;
    }

    public void setRateTv(String rateTv) {
        this.rateTv = rateTv;
    }

    public int getPosterTv() {
        return posterTv;
    }

    public void setPosterTv(int posterTv) {
        this.posterTv = posterTv;
    }

    private int posterTv;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.titleTv);
        dest.writeString(this.dateTv);
        dest.writeString(this.descTv);
        dest.writeString(this.rateTv);
        dest.writeInt(this.posterTv);
    }

    public TvShow() {
    }

    protected TvShow(Parcel in) {
        this.titleTv = in.readString();
        this.dateTv = in.readString();
        this.descTv = in.readString();
        this.rateTv = in.readString();
        this.posterTv = in.readInt();
    }

    public static final Parcelable.Creator<TvShow> CREATOR = new Parcelable.Creator<TvShow>() {
        @Override
        public TvShow createFromParcel(Parcel source) {
            return new TvShow(source);
        }

        @Override
        public TvShow[] newArray(int size) {
            return new TvShow[size];
        }
    };
}
