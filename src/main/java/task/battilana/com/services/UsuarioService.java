package task.battilana.com.services;

import task.battilana.com.dto.response.UsuarioResponse;

import java.util.List;

public interface UsuarioService {

    List<UsuarioResponse> listado ();
    UsuarioResponse registrar (UsuarioResponse usuarioResponse);
}
