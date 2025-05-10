package task.battilana.com.services;

import task.battilana.com.dto.UsuarioDto;

import java.util.List;

public interface UsuarioService {

    List<UsuarioDto> listado ();
    UsuarioDto registrar (UsuarioDto usuarioDto);
}
