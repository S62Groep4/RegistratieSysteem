/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package domain;

import java.io.Serializable;
import javax.enterprise.inject.Model;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author M
 */
@Entity
@Model
public class Account implements Serializable{

    @Id
    private Long id;
    private String name = null;
    private String email = null;
    private String password = null;
    
    public Account(){
        
    }
    
    public Account(String name, String email, String password){
        this.name = name;
        this.email = email;
        this.password = password;
    }

    public String getUserName() {
        return this.getName();
    }

    public String getUserEmail() {
        return this.email;
    }

    public String getPassword() {
        return this.password;
    }
    
    public Long getId(){
        return this.id;
    }

    public void setUserName(String name) {
        this.name = name;
    }

    public void setUserEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setId(Long id){
        this.id = id;
    }
    
}
