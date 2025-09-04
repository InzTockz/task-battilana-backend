package task.battilana.com.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import task.battilana.com.dto.UsuarioRequest;
import task.battilana.com.dto.UsuarioResponse;
import task.battilana.com.entity.UsuariosEntity;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2025-09-03T20:48:37-0500",
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

        String nombres = null;
        String apellidos = null;
        String correo = null;
        Boolean estado = null;
        String roles = null;

        nombres = usuarioEntity.getNombres();
        apellidos = usuarioEntity.getApellidos();
        correo = usuarioEntity.getCorreo();
        estado = usuarioEntity.getEstado();
        if ( usuarioEntity.getRoles() != null ) {
            roles = usuarioEntity.getRoles().name();
        }

        UsuarioResponse usuarioResponse = new UsuarioResponse( nombres, apellidos, correo, estado, roles );

        return usuarioResponse;
    }

    @Override
    public UsuariosEntity usuariosEntityMapper(UsuarioRequest usuarioRequest) {
        if ( usuarioRequest == null ) {
            return null;
        }

        UsuariosEntity usuariosEntity = new UsuariosEntity();

        usuariosEntity.setNombres( usuarioRequest.nombres() );
        usuariosEntity.setApellidos( usuarioRequest.apellidos() );
        usuariosEntity.setCorreo( usuarioRequest.correo() );
        usuariosEntity.setPassword( usuarioRequest.password() );

        return usuariosEntity;
    }
}
