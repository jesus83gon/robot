/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rob.conf.robot.Entity;

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
@Entity
public class Usuario {
    @Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Long id;
	private String nombreUsuario;
	private String loging;
	private String clave;
        private Date fechaDeCarga;
        
        @JoinColumn(name="rol_id",unique=true)
	@OneToOne(cascade=CascadeType.ALL)
	private Rol rol;

    public Usuario() {
    }

    public Usuario(Long id, String nombreUsuario, String loging, String clave, Date fechaDeCarga, Rol rol) {
        this.id = id;
        this.nombreUsuario = nombreUsuario;
        this.loging = loging;
        this.clave = clave;
        this.fechaDeCarga = fechaDeCarga;
        this.rol = rol;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
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

    public Date getFechaDeCarga() {
        return fechaDeCarga;
    }

    public void setFechaDeCarga(Date fechaDeCarga) {
        this.fechaDeCarga = fechaDeCarga;
    }

    public Rol getRol() {
        return rol;
    }

    public void setRol(Rol rol) {
        this.rol = rol;
    }

    @Override
    public String toString() {
        return "Usuario{" + "id=" + id + ", nombreUsuario=" + nombreUsuario + ", loging=" + loging + ", clave=" + clave + ", fechaDeCarga=" + fechaDeCarga + ", rol=" + rol + '}';
    }
}
