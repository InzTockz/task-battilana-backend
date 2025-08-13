package task.battilana.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.battilana.com.dto.response.UsuarioResponse;
import task.battilana.com.services.UsuarioService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/usuario")
@CrossOrigin("*")
public class UsuarioController {

    private final UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @RequestMapping("/listar")
    public ResponseEntity<List<UsuarioResponse>> listado(){
        return ResponseEntity.status(HttpStatus.OK).body(this.usuarioService.listado());
    }

    @PostMapping("/registrar")
    public ResponseEntity<UsuarioResponse> registrar(@RequestBody UsuarioResponse usuarioResponse){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.usuarioService.registrar(usuarioResponse));
    }
}
