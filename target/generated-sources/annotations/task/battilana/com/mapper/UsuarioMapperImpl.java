package task.battilana.com.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import task.battilana.com.dto.UsuarioDto;
import task.battilana.com.entity.UsuariosEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-05-12T12:54:24-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public List<UsuarioDto> listadoUsuarioMapper(List<UsuariosEntity> listadoUsuariosEntity) {
        if ( listadoUsuariosEntity == null ) {
            return null;
        }

        List<UsuarioDto> list = new ArrayList<UsuarioDto>( listadoUsuariosEntity.size() );
        for ( UsuariosEntity usuariosEntity : listadoUsuariosEntity ) {
            list.add( usuarioDtoMapper( usuariosEntity ) );
        }

        return list;
    }

    @Override
    public UsuarioDto usuarioDtoMapper(UsuariosEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        Long idUsuarios = null;
        String nombres = null;
        String correo = null;

        idUsuarios = usuarioEntity.getIdUsuarios();
        nombres = usuarioEntity.getNombres();
        correo = usuarioEntity.getCorreo();

        UsuarioDto usuarioDto = new UsuarioDto( idUsuarios, nombres, correo );

        return usuarioDto;
    }

    @Override
    public UsuariosEntity usuariosEntityMapper(UsuarioDto usuarioDto) {
        if ( usuarioDto == null ) {
            return null;
        }

        UsuariosEntity usuariosEntity = new UsuariosEntity();

        usuariosEntity.setIdUsuarios( usuarioDto.idUsuarios() );
        usuariosEntity.setNombres( usuarioDto.nombres() );
        usuariosEntity.setCorreo( usuarioDto.correo() );

        return usuariosEntity;
    }
}
