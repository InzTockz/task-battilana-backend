package task.battilana.com.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import task.battilana.com.dto.response.UsuarioResponse;
import task.battilana.com.entity.UsuariosEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-08-13T14:48:26-0500",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 21.0.5 (Eclipse Adoptium)"
)
@Component
public class UsuarioMapperImpl implements UsuarioMapper {

    @Override
    public List<UsuarioResponse> listadoUsuarioMapper(List<UsuariosEntity> listadoUsuariosEntity) {
        if ( listadoUsuariosEntity == null ) {
            return null;
        }

        List<UsuarioResponse> list = new ArrayList<UsuarioResponse>( listadoUsuariosEntity.size() );
        for ( UsuariosEntity usuariosEntity : listadoUsuariosEntity ) {
            list.add( usuarioDtoMapper( usuariosEntity ) );
        }

        return list;
    }

    @Override
    public UsuarioResponse usuarioDtoMapper(UsuariosEntity usuarioEntity) {
        if ( usuarioEntity == null ) {
            return null;
        }

        Long idUsuarios = null;
        String nombres = null;
        String correo = null;

        idUsuarios = usuarioEntity.getIdUsuarios();
        nombres = usuarioEntity.getNombres();
        correo = usuarioEntity.getCorreo();

        UsuarioResponse usuarioResponse = new UsuarioResponse( idUsuarios, nombres, correo );

        return usuarioResponse;
    }

    @Override
    public UsuariosEntity usuariosEntityMapper(UsuarioResponse usuarioResponse) {
        if ( usuarioResponse == null ) {
            return null;
        }

        UsuariosEntity usuariosEntity = new UsuariosEntity();

        usuariosEntity.setIdUsuarios( usuarioResponse.idUsuarios() );
        usuariosEntity.setNombres( usuarioResponse.nombres() );
        usuariosEntity.setCorreo( usuarioResponse.correo() );

        return usuariosEntity;
    }
}
