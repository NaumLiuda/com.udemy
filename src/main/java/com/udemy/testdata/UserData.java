package com.udemy.testdata;

import com.udemy.models.User;
import java.sql.Timestamp;

public interface UserData {
    int timestamp = new Timestamp(System.currentTimeMillis()).getNanos();

    User basicUser = new User("Nester","test.nester" + timestamp + "@gmail.com","147852Zx!");
}