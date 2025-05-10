package task.battilana.com.services.impl;

import org.springframework.stereotype.Service;
import task.battilana.com.dto.UsuarioDto;
import task.battilana.com.mapper.UsuarioMapper;
import task.battilana.com.repository.UsuarioRepository;
import task.battilana.com.services.UsuarioService;

import java.util.List;

@Service
public class UsuarioServiceImpl implements UsuarioService {

    private final UsuarioMapper usuarioMapper;
    private final UsuarioRepository usuarioRepository;

    public UsuarioServiceImpl(UsuarioMapper usuarioMapper, UsuarioRepository usuarioRepository) {
        this.usuarioMapper = usuarioMapper;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<UsuarioDto> listado() {
        return this.usuarioMapper.listadoUsuarioMapper(this.usuarioRepository.findAll());
    }

    @Override
    public UsuarioDto registrar(UsuarioDto usuarioDto) {
        return this.usuarioMapper.usuarioDtoMapper(this.usuarioRepository.save(this.usuarioMapper.usuariosEntityMapper(usuarioDto)));
    }
}
