package com.udemy.testdata;

import com.udemy.models.User;

import java.sql.Timestamp;

public interface UserData {
    int timestamp = new Timestamp(System.currentTimeMillis()).getNanos();


    User newUser = new User()
            .setName("Nest")
            .setEmail("test.nester"+System.currentTimeMillis()+"@appcreative.net")
            .setPassword("test"+timestamp+"!&");


    User basicUser =  new User ("dj_session_id", "her50492ns8ojvia6c39woqrz2cu54ia");

}