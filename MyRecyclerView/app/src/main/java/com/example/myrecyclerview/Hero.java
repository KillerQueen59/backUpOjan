package com.example.myrecyclerview;

import android.os.Parcel;
import android.os.Parcelable;

public class Hero implements Parcelable { // agar data tiap list kesimpen
    private String namaHero;
    private String descHero;
    private String photoHero;

    protected Hero(Parcel in) {
        namaHero = in.readString();
        descHero = in.readString();
        photoHero = in.readString();
    }

    public static final Creator<Hero> CREATOR = new Creator<Hero>() {
        @Override
        public Hero createFromParcel(Parcel in) {
            return new Hero(in);
        }

        @Override
        public Hero[] newArray(int size) {
            return new Hero[size];
        }
    };
    Hero(){

    }

    public String getNamaHero() {
        return namaHero;
    }

    public void setNamaHero(String namaHero) {
        this.namaHero = namaHero;
    }

    public String getDescHero() {
        return descHero;
    }

    public void setDescHero(String descHero) {
        this.descHero = descHero;
    }

    public String getPhotoHero() {
        return photoHero;
    }

    public void setPhotoHero(String photoHero) {
        this.photoHero = photoHero;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(namaHero);
        dest.writeString(descHero);
        dest.writeString(photoHero);
    }
}
