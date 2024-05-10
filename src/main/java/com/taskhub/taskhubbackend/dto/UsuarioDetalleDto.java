package com.taskhub.taskhubbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDetalleDto {

    private Integer idUsuario;
    private String usuarioIngreso;
    private String correo;
    private String nombres;
    private String apellidos;
}
