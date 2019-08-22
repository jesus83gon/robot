/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rob.conf.robot.dto;

import java.sql.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;

/**
 *
 * @author audra.zapata
 */

public class LoginDto {
 
    private String loging;
    private String clave;
    
    public LoginDto() {
    }

    public LoginDto(String loging, String clave) {
        this.loging = loging;
        this.clave = clave;
    }

    public String getLoging() {
        return loging;
    }

    public void setLoging(String loging) {
        this.loging = loging;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    @Override
    public String toString() {
        return "LoginDto{" + "loging=" + loging + ", clave=" + clave + '}';
    }
}
