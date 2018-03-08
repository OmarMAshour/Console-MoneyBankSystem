/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package user;

/**
 *
 * @author root
 */
public abstract class User {
    
    
    protected String name;
    protected String username;
    protected String id;
    protected String password;

    public User() {
    }

    public User(String name, String username, String password) {
        this.name = name;
        this.username = username;
//        this.id = id;
        this.password = password;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public String getUsername() {
        return username;
    }
    
    public void ShowData(){
        System.out.println("ID: "+ this.id);
        System.out.println("Name: "+ this.name);
        System.out.println("Username: "+ this.username);
    }
    
    
    
}
