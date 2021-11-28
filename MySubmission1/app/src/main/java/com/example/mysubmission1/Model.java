package com.example.mysubmission1;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class Model extends ArrayList<Parcelable> implements Parcelable {
    private String username;
    private String name;
    private String company;
    private String location;
    private int avatar;
    private int repository;
    private int following;
    private int follower;

//    setter getter

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAvatar() {
        return avatar;
    }

    public void setAvatar(int avatar) {
        this.avatar = avatar;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getRepository() {
        return repository;
    }

    public void setRepository(int repository) {
        this.repository = repository;
    }

    public int getFollowing() {
        return following;
    }

    public void setFollowing(int following) {
        this.following = following;
    }

    public int getFollower() {
        return follower;
    }

    public void setFollower(int follower) {
        this.follower = follower;
    }

//    parcelable

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.username);
        dest.writeString(this.name);
        dest.writeString(this.company);
        dest.writeString(this.location);
        dest.writeInt(this.repository);
        dest.writeInt(this.following);
        dest.writeInt(this.follower);
        dest.writeInt(this.avatar);
    }

    Model(){

    }

    protected Model(Parcel in) {
        username = in.readString();
        name = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readInt();
        following = in.readInt();
        follower = in.readInt();
        avatar = in.readInt();
    }

    public static final Parcelable.Creator<Model> CREATOR = new Parcelable.Creator<Model>() {
        @Override
        public Model createFromParcel(Parcel source) {
            return new Model(source);
        }

        @Override
        public Model[] newArray(int size) {
            return new Model[size];
        }
    };
}
