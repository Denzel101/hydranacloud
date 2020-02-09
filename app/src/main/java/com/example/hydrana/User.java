package com.example.hydrana;

public class User {

    private String Name;
    private  String Password;
    private  String number;

    public User (){

    }



    public User(String name, String password, String number) {
        this.Name = name;
        this.Password = password;
        this.number = number;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }
}
