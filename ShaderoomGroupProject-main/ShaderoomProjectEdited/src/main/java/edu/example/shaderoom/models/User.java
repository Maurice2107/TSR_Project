package edu.example.shaderoom.models;

import com.google.cloud.firestore.annotation.DocumentId;

import java.io.File;

public class User {
    @DocumentId
    private String id;
    private String userName;
    private String firstName;
    private String lastName;
    private String email;
    private String password;
    private File image;

    private String uid;

    public User()
    {

    }
    public User(String id,String userName, String firstName,String lastName,String email,String password, File image, String uid){
        this.id = id;
        this.userName = userName;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
        this.image = image;
        this.uid = uid;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
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

    public File getImage() {
        return image;
    }

    public void setImage(File image) {
        this.image = image;
    }

    public String getUid(){return uid;}

    public void setUid(String uid) { this.uid = uid;}
}
