package com.example.intent;

import android.os.Parcel;
import android.os.Parcelable;

public class Person implements Parcelable {
    private String Name;
    private int Age;
    private String Email;

    // Parcelable adalah suatu interface yang memungkinkan kita melakukan pengiriman objek dari suatu Activity ke Activity lain.


    public String getName() { // setter and getter untuk mengakses kelas yang di private
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public int getAge() {
        return Age;
    }

    public void setAge(int age) {
        Age = age;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    private String City;

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.Name);
        dest.writeInt(this.Age);
        dest.writeString(this.Email);
        dest.writeString(this.City);
    }

    public Person() {
    }

    protected Person(Parcel in) {
        this.Name = in.readString();
        this.Age = in.readInt();
        this.Email = in.readString();
        this.City = in.readString();
    }

    public static final Parcelable.Creator<Person> CREATOR = new Parcelable.Creator<Person>() {
        @Override
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        @Override
        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
}
