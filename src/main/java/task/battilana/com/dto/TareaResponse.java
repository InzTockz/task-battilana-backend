package task.battilana.com.dto;

import task.battilana.com.entity.EstadoEnum;

import java.time.LocalDate;

public record TareaResponse (
        Long idTarea,
        String nombreTarea,
        String descripcion,
        EstadoEnum estado,
        LocalDate fechaCreacion,
        String fechaInicio,
        String fechaFin,
        Long idUsuariosEntity,
        String nombreUsuarioEntity,
        Long idCarpeta
){
}
