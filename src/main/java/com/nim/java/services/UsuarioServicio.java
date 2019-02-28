/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.nim.java.services;

import com.nim.java.dao.UsuarioDAO;
import com.nim.java.model.Usuario;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 *
 * @author Nimrod
 */
@Path("usuarios")
public class UsuarioServicio {
    
    private static List<Usuario> lista = UsuarioDAO.getUsuarios();
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarios() {
        
        return Response.ok(lista).build();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("id") int id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        
        if(lista.contains(usuario)) {
            for(Usuario obj: lista) {
                if(obj.getId() == id) {
                    return Response.ok(obj).build();
                }
            }
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response borrarUsuario(@PathParam("id") int id) {
        Usuario usuario = new Usuario();
        usuario.setId(id);
        
        if(lista.contains(usuario)) {
            lista.remove(usuario);
            return Response.ok().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
    
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardarUsuario(Usuario usuario) {
        
        lista.add(usuario);
        
        return Response.status(Response.Status.CREATED).entity(usuario).build();
        
    }
    
}
