package com.example.materialdesign;

import android.os.Parcel;
import android.os.Parcelable;

public class Avengers implements Parcelable {
    private String name;
    private String desc;

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    private String nick;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    private String photo;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.desc);
        dest.writeString(this.photo);
    }
    public Avengers() {
    }
    protected Avengers(Parcel in) {
        this.name = in.readString();
        this.desc = in.readString();
        this.photo = in.readString();
    }
    public static final Parcelable.Creator<Avengers> CREATOR = new Parcelable.Creator<Avengers>() {
        @Override
        public Avengers createFromParcel(Parcel source) {
            return new Avengers(source);
        }
        @Override
        public Avengers[] newArray(int size) {
            return new Avengers[size];
        }
    };
}
