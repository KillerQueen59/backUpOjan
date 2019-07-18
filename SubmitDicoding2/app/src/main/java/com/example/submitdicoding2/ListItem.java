package com.example.submitdicoding2;

import android.os.Parcel;
import android.os.Parcelable;

public class ListItem implements Parcelable {
    private int ImageResource;
    private String Player;
    private String Club;
    private String Price;
    private String Details;

    public ListItem(int imageResource,String player,String club,String price,String details){
        ImageResource = imageResource;
        Player = player;
        Club = club;
        Price = price;
        Details  = details;
    }

    protected ListItem(Parcel in) {
        ImageResource = in.readInt();
        Player = in.readString();
        Club = in.readString();
        Price = in.readString();
        Details = in.readString();
    }

    public static final Creator<ListItem> CREATOR = new Creator<ListItem>() {
        @Override
        public ListItem createFromParcel(Parcel in) {
            return new ListItem(in);
        }

        @Override
        public ListItem[] newArray(int size) {
            return new ListItem[size];
        }
    };

    public int getImageResource(){return ImageResource; }

    public String getClub() {
        return Club;
    }

    public String getPlayer() {
        return Player;
    }

    public String getPrice() {
        return Price;
    }

    public String getDetails() {
        return Details;
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
