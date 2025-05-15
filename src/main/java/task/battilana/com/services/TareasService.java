package task.battilana.com.services;

import task.battilana.com.dto.request.TareaRequest;
import task.battilana.com.dto.response.TareaResponse;

import java.util.List;

public interface TareasService {

    List<TareaResponse> listado();
    TareaResponse registrar (TareaRequest tareaDto);
    TareaResponse actualizar (Long id, TareaRequest tareaDto);
    TareaResponse buscar (Long id);
    void eliminar (Long id);
    Integer contadorPendientes();
    Integer contadorTerminados();
    void actualizarEstado (Long id);
}
