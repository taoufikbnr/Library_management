/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaapplication1;

/**
 *
 * @author lenovo
 */
public class CurrentUser {
    public static CurrentUser instance;
    private String username;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private CurrentUser(String username) {
        this.username = username;
    }

    public static void setCurrentUser(String username) {
        instance = new CurrentUser(username);
    }
}