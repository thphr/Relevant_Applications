package com.example.bruger.pictureexplore;

import java.io.Serializable;

/**
 * Created by Bruger on 21-08-2018.
 */

public class Photo implements Serializable {

    private String id;
    private String owner;
    private String secret;
    private String farmID;
    private String serverID;
    private String title;

    public Photo(String ID, String Owner, String secret, String farmID, String serverID, String title) {
        this.id = ID;
        this.owner = Owner;
        this.secret = secret;
        this.farmID = farmID;
        this.serverID = serverID;
        this.title = title;
    }


    public String getId() {
        return id;

    }

    public String getOwner() {
        return owner;

    }

    public String getSecret() {
        return secret;
    }

    public String getFarmID() {
        return farmID;
    }

    public String getServerID() {
        return serverID;
    }

    public String getTitle() {
        return title;
    }


    @Override
    public String toString() {
        return "Photo{" +
                "ID='" + getId() + '\'' +
                ", owner='" + getOwner() + '\'' +
                ", secret ='" + getSecret() + '\'' +
                ", farmID ='" + getFarmID() + '\'' +
                ", serverID ='" + getServerID() + '\'' +
                ", title ='" + getTitle() + '\'' +
                '}';
    }
}
