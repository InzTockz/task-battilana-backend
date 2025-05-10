package task.battilana.com.dto.request;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record TareaRequest(
        String nombreTarea,
        String descripcion,
        String fechaInicio,
        String fechaFin,
        Long idUsuariosEntity
) {
}
