package com.taskhub.taskhubbackend.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LoginResponse {
    private String token;
    private UsuarioDetalleDto usuarioDetalleDto;

    public LoginResponse(String token, UsuarioDetalleDto usuarioDetalleDto) {
        this.token = token;
        this.usuarioDetalleDto = usuarioDetalleDto;
    }
}