package com.taskhub.taskhubbackend.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class FechaFiltroDTO {
    private Date fechaInicio;
    private Date fechaFin;
}