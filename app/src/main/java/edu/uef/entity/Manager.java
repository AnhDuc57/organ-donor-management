package edu.uef.entity;

import java.util.Date;

public class Manager extends Person{
    private String userName;
    private String password;

    public Manager() {
    }

    public Manager(String userName, String password) {
        this.userName = userName;
        this.password = password;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Manager(int id, String firstName, String lastName, int gender, Date birthday, String address, String phoneNumber, String email, String userName, String password) {
        super(id, firstName, lastName, gender, birthday, address, phoneNumber, email);
        this.userName = userName;
        this.password = password;
    }

    public Manager(String firstName, String lastName, int gender, Date birthday, String address, String phoneNumber, String email, String userName, String password) {
        super(firstName, lastName, gender, birthday, address, phoneNumber, email);
        this.userName = userName;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Manager{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
