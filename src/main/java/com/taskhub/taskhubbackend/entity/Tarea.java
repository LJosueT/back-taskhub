package com.taskhub.taskhubbackend.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tareas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Tarea {

    @Id
    @Column(name = "id_tarea")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idTarea;

    @Column(name = "nombre", length = 50)
    private String nombre;

    @Column(name = "descripcion", length = 200)
    private String descripcion;

    @Column(name = "fecha_fin")
    private Date fechaFin; //yyyy-MM-ddThh:mm:ss

    @Column(name = "prioridad", length = 10)
    private String prioridad;

    @Column(name = "estado", length = 1)
    private String estado;

    @Column(name = "id_usuario")
    private Integer idUsuario;
}
