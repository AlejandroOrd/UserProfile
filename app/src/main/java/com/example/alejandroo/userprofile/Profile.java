package com.example.alejandroo.userprofile;

public class Profile {
    private String name, lastname, handle, following, followers, about;

    public String getName() {
        return name+" "+lastname;
    }


    public String getHandle() {
        return handle;
    }

    public String getFollowing() {
        return following;
    }

    public String getFollowers() {
        return followers;
    }

    public String getAbout() {
        return about;
    }
}
