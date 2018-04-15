package com.example.habibaabbasii.mysqliteapp.model;

public class User {

   private String Name;
   private String Email;
   private String Password;

    public User(String Name,String Password,String Email){
        this.Name= Name;
        this.Email=Email;
        this.Password=Password;

    }



    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }



}
