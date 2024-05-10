package com.taskhub.taskhubbackend.repository;

import com.taskhub.taskhubbackend.entity.Tarea;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Date;
import java.util.List;

public interface TareaRepository extends JpaRepository<Tarea, Integer> {
    @Query("SELECT t FROM Tarea t WHERE t.idUsuario = :usuarioId AND t.fechaFin BETWEEN :fechaInicio AND :fechaFin")
    List<Tarea> findByUsuarioIdAndFechaFinBetween(Integer usuarioId, Date fechaInicio, Date fechaFin);

    @Query("SELECT t FROM Tarea t WHERE t.idUsuario = :usuarioId")
    List<Tarea> findByUsuarioId(Integer usuarioId);
}
