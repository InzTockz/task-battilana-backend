package task.battilana.com.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.http.ResponseEntity;
import task.battilana.com.dto.request.TareaRequest;
import task.battilana.com.dto.response.TareaResponse;
import task.battilana.com.entity.TareasEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TareaMapper {

    @Mapping(target = "idUsuariosEntity", source = "usuariosEntity.idUsuarios")
    @Mapping(target = "nombreUsuarioEntity", source = "usuariosEntity.nombres")
    List<TareaResponse> listadoTareaDto(List<TareasEntity> listadoTareasEntity);

    @Mapping(target = "idUsuariosEntity", source = "usuariosEntity.idUsuarios")
    @Mapping(target = "estado", source = "estadoEnum")
    @Mapping(target = "nombreUsuarioEntity", source = "usuariosEntity.nombres")
    TareaResponse tareaDtoResponse (TareasEntity tareasEntity);

    @Mapping(target = "usuariosEntity.idUsuarios", source = "idUsuariosEntity")
    TareasEntity tareasEntityMapper (TareaRequest tareaDto);

}
