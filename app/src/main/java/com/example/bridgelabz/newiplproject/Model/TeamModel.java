package com.example.bridgelabz.newiplproject.Model;

/**
 * Created by bridgelabz on 22/11/16.
 */

public class TeamModel {


    String teamname;
    String url;

    String owner;

    public TeamModel() {
    }

    public TeamModel(String teamname, String url, String owner) {
        this.teamname = teamname;
        this.url = url;
        this.owner = owner;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }
}