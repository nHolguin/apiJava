/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nim.java.dao;

import com.nim.java.model.Usuario;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Nimrod
 */
public class UsuarioDAO {
    public static List<Usuario> getUsuarios() {
        List<Usuario> lista = new ArrayList();
        
        Usuario usuario1 = new Usuario(1,"Nim1","Hol",29);
        Usuario usuario2 = new Usuario(2,"Nim2","Hol",29);
        Usuario usuario3 = new Usuario(3,"Nim3","Hol",29);
        Usuario usuario4 = new Usuario(4,"Nim4","Hol",29);
        Usuario usuario5 = new Usuario(5,"Nim5","Hol",29);
        
        lista.add(usuario1);
        lista.add(usuario2);
        lista.add(usuario3);
        lista.add(usuario4);
        lista.add(usuario5);
        
        return lista;
    }
}
