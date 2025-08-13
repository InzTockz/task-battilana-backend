package task.battilana.com.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import task.battilana.com.dto.response.UsuarioResponse;
import task.battilana.com.entity.UsuariosEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    //UsuarioDto USUARIO_MAPPER = Mappers.getMapper(UsuarioDto.class);

    List<UsuarioResponse> listadoUsuarioMapper(List<UsuariosEntity> listadoUsuariosEntity);
    UsuarioResponse usuarioDtoMapper(UsuariosEntity usuarioEntity);

    @InheritInverseConfiguration
    UsuariosEntity usuariosEntityMapper(UsuarioResponse usuarioResponse);
}
