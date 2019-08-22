/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.rob.conf.robot.controller;

import com.rob.conf.robot.Entity.ConexionAs;
import com.rob.conf.robot.Entity.Usuario;
import com.rob.conf.robot.dto.LoginDto;
import com.rob.conf.robot.reposiroty.ConexionAsRepository;
import com.rob.conf.robot.reposiroty.UsuarioRepository;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

/**
 *
 * @author audra.zapata
 */
@Controller
public class UsuarioController {
    @Autowired
    UsuarioRepository repo;
    @Autowired
    ConexionAsRepository repoAs;

    @GetMapping
    public String index(Model modelo,LoginDto loginDto){
    modelo.addAttribute("loginDto", new LoginDto());
 
        return "login";
    }
    
    
    
    @PostMapping("/login")
    public String login(Model modelo,LoginDto login){
            
         modelo.addAttribute("servidores",repoAs.findAll());
        
         if(false){ 
             modelo.addAttribute("conexionAs",new ConexionAs());
             return "panel";
         }else{
             modelo.addAttribute("usuario",new Usuario());
             return "index";
         }
        

    
    }
    
    
    @PostMapping("/crearConexion")
    public String crearConexion(Model modelo,ConexionAs conexionAs){
        //conexionAs.setIdUsuario(repo.findById(1L).get().getId());
        conexionAs.setIdUsuario(1L);
        Date a= new Date();
       conexionAs.setFechaCreacion(new java.sql.Date(a.getTime()));
        repoAs.save(conexionAs);
        modelo.addAttribute("conexionAs", new ConexionAs());
        modelo.addAttribute("conexionesAs", repoAs.findAll());
       
    return "panel";
    }
    
    
      @GetMapping("/editarConexion/{id}")
    public String editarConexion(Model modelo,@PathVariable(name = "id") Long id){
    ConexionAs conexionEditar = repoAs.findById(id).get();
        modelo.addAttribute("conexionAs", conexionEditar);
        modelo.addAttribute("conexionesAs", repoAs.findAll());
    
    return "panel";
    }
    
    
    @GetMapping("/eliminarConexion/{id}")
    public String eliminarConexion(Model modelo,@PathVariable(name = "id") Long id){
    repoAs.deleteById(id);
        modelo.addAttribute("conexionAs", new ConexionAs());
        modelo.addAttribute("conexionesAs", repoAs.findAll());
        return "panel";
    }
    
    
    
    @PostMapping("/crearUsuario")
    public String crearUsuario(Model modelo,Usuario usuario){
        repo.save(usuario);
        modelo.addAttribute("usuario", new Usuario());
        modelo.addAttribute("usuarios",repo.findAll());

    return "index";
    }
    
    @GetMapping("/editarUsuario/{id}")
    public String editarUsuario(Model modelo,@PathVariable(name = "id") Long id){
    Usuario usuarioEditar = repo.findById(id).get();
    modelo.addAttribute("usuario", usuarioEditar);
    modelo.addAttribute("usuarios",repo.findAll());
    
    return "index";
    }
    @GetMapping("/eliminarUsuario/{id}")
    public String eliminarUsuario(Model modelo,@PathVariable(name = "id") Long id){
    repo.deleteById(id);
        modelo.addAttribute("usuario",  new Usuario());
        modelo.addAttribute("usuarios",repo.findAll());
        return "index";
    }
    
    
}
