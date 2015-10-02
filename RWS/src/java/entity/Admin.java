/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author andrew.lim.2013
 */
public class Admin {
    private String id;
    private String password;
    private String email;
    private String name;
    private String role;

    public Admin(String id, String password, String email, String name, String role) {
        this.id = id;
        this.password = password;
        this.email = email;
        this.name = name;
        this.role = role;
    }

    public String getId() {
        return id;
    }

    public String getPassword() {
        return password;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getRole() {
        return role;
    } 
}
