package com.taskhub.taskhubbackend.dto;

import com.taskhub.taskhubbackend.entity.Tarea;
import com.taskhub.taskhubbackend.entity.Usuario;
import lombok.Data;

import java.util.List;

@Data
public class Response {

    private String mensaje;
    private Usuario usuario;
    private Tarea tarea;
    private List<Tarea> tareas;

    public Response(String mensaje, Usuario usuario) {
        this.mensaje = mensaje;
        this.usuario = usuario;
    }
    public Response(String mensaje, Tarea tarea) {
        this.mensaje = mensaje;
        this.tarea = tarea;
    }

    public Response(String mensaje, List<Tarea> tareas) {
        this.mensaje = mensaje;
        this.tareas = tareas;
    }
}