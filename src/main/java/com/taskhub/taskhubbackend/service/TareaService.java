package com.taskhub.taskhubbackend.service;

import com.taskhub.taskhubbackend.dto.TareaDto;
import com.taskhub.taskhubbackend.entity.Tarea;
import com.taskhub.taskhubbackend.entity.Usuario;
import com.taskhub.taskhubbackend.repository.TareaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TareaService {

    private final TareaRepository tareaRepository;
    private final UsuarioService usuarioService;

    @Autowired
    public TareaService(TareaRepository tareaRepository, UsuarioService usuarioService) {
        this.tareaRepository = tareaRepository;
        this.usuarioService = usuarioService;
    }

    public boolean verificarIdUsuarioTarea(Integer id){
        Usuario usuario = usuarioService.buscarIdUsuario(id);
        if (usuario != null) {
            return true;
        } else {
            return false;
        }
    }

    public Tarea registrarTarea(TareaDto TareaDTO) {
        Tarea tarea = new Tarea();
        if(verificarIdUsuarioTarea(TareaDTO.getId_usuario())){
            tarea.setNombre(TareaDTO.getNombre());
            tarea.setDescripcion(TareaDTO.getDescripcion());
            tarea.setFechaFin(TareaDTO.getFecha_fin());
            tarea.setPrioridad(TareaDTO.getPrioridad());
            tarea.setEstado(TareaDTO.getEstado());
            tarea.setIdUsuario(TareaDTO.getId_usuario());
            return tareaRepository.save(tarea);
        }
        return null;
    }
    public Tarea buscarIdTarea(Integer idTarea) {
        return tareaRepository.findById(idTarea).orElse(null);
    }
    public Tarea editarTarea(Integer idTarea, TareaDto tareaDto) {
        Tarea tareaExistente = buscarIdTarea(idTarea);
        if (tareaExistente != null) {
            tareaExistente.setNombre(tareaDto.getNombre());
            tareaExistente.setDescripcion(tareaDto.getDescripcion());
            tareaExistente.setFechaFin(tareaDto.getFecha_fin());
            tareaExistente.setPrioridad(tareaDto.getPrioridad());
            tareaExistente.setEstado(tareaDto.getEstado());
            return tareaRepository.save(tareaExistente);
        }
        return null;
    }
    public void eliminarTarea(Integer idTarea) {
        tareaRepository.deleteById(idTarea);
    }

    public List<Tarea> mostrarTareas(Integer usuarioId) {
        List<Tarea> tareas = new ArrayList<>();
        if(verificarIdUsuarioTarea(usuarioId)){
            tareas = tareaRepository.findByUsuarioId(usuarioId);
        }
        else{
            Tarea tareaDummy = new Tarea();
            tareaDummy.setIdTarea(-1);
            tareas.add(tareaDummy);
        }
        return tareas;
    }

    public List<Tarea> filtrarTareasPorRangoDeFechas(Integer usuarioId, Date fechaInicio, Date fechaFin) {
        List<Tarea> tareas = new ArrayList<>();
        if(verificarIdUsuarioTarea(usuarioId)){
            tareas = tareaRepository.findByUsuarioIdAndFechaFinBetween(usuarioId, fechaInicio, fechaFin);
        }
        else{
            Tarea tareaDummy = new Tarea();
            tareaDummy.setIdTarea(-1);
            tareas.add(tareaDummy);
        }
        return tareas;
    }

}