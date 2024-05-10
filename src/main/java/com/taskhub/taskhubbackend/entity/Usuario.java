package com.taskhub.taskhubbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "usuario")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Usuario {

    @Id
    @Column(name = "id_usuario")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    @Column(name = "usuario_ingreso", length = 50)
    private String usuarioIngreso;

    @Column(name = "contraseña", length = 50)
    private String contraseña;

    @Column(name = "correo", length = 50)
    private String correo;

    @Column(name = "nombres", length = 50)
    private String nombres;

    @Column(name = "apellidos", length = 50)
    private String apellidos;

    @Column(name = "estado", length = 1)
    private String estado;

    @Column(name = "fecha_creacion")
    private Date fechaCreacion;

}
