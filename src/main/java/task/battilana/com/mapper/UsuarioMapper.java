package task.battilana.com.mapper;

import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;
import task.battilana.com.dto.UsuarioDto;
import task.battilana.com.entity.UsuariosEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {

    //UsuarioDto USUARIO_MAPPER = Mappers.getMapper(UsuarioDto.class);

    List<UsuarioDto> listadoUsuarioMapper(List<UsuariosEntity> listadoUsuariosEntity);
    UsuarioDto usuarioDtoMapper(UsuariosEntity usuarioEntity);

    @InheritInverseConfiguration
    UsuariosEntity usuariosEntityMapper(UsuarioDto usuarioDto);
}
