package com.taskhub.taskhubbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class TareaDto {
    private String nombre;
    private String descripcion;
    private Date fecha_fin;
    private String prioridad;
    private String estado;
    private Integer id_usuario;
}
