package com.myweb;

/**
 * Created by Виталик on 26.05.2016.
 */
public class User {

    int id;
    String name;
    String email;
    String password;
    User(int id,
         String name,
         String email,
         String password){
        this.id=id;
        this.name=name;
        this.email=email;
        this.password=password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
