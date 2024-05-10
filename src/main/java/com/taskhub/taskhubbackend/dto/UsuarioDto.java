package com.taskhub.taskhubbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioDto {

    private String usuarioIngreso;
    private String contraseña;
    private String correo;
    private String nombres;
    private String apellidos;
}