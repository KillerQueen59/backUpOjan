package com.example.submitdicoding2;

import android.os.Parcel;
import android.os.Parcelable;

public class GridItem implements Parcelable {
    private int ImageResource;
    private String Player;
    private String Club;
    private String Price;
    private String Details;
    public GridItem(int imageResource,String player,String club,String price,String details){
        ImageResource = imageResource;
        Player = player;
        Club = club;
        Price = price;
        Details  = details;
    }

    protected GridItem(Parcel in) {
        ImageResource = in.readInt();
        Player = in.readString();
        Club = in.readString();
        Price = in.readString();
        Details = in.readString();
    }

    public static final Creator<GridItem> CREATOR = new Creator<GridItem>() {
        @Override
        public GridItem createFromParcel(Parcel in) {
            return new GridItem(in);
        }

        @Override
        public GridItem[] newArray(int size) {
            return new GridItem[size];
        }
    };

    public int getImageResource(){
        return ImageResource;
    }

    public String getDetails() {
        return Details;
    }

    public String getPrice() {
        return Price;
    }

    public String getPlayer() {
        return Player;
    }

    public String getClub() {
        return Club;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(ImageResource);
        dest.writeString(Player);
        dest.writeString(Club);
        dest.writeString(Price);
        dest.writeString(Details);
    }
}
