package task.battilana.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.battilana.com.dto.CarpetaRequest;
import task.battilana.com.dto.CarpetaResponse;
import task.battilana.com.services.CarpetasService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/carpetas")
@CrossOrigin("*")
public class CarpetasController {

    private final CarpetasService carpetasService;

    public CarpetasController(CarpetasService carpetasService) {
        this.carpetasService = carpetasService;
    }

    @GetMapping("/listado")
    public ResponseEntity<List<CarpetaResponse>> findAll(){
        return ResponseEntity.status(HttpStatus.OK).body(this.carpetasService.findAll());
    }

    @PostMapping("/registrar")
    public ResponseEntity<CarpetaResponse> registrar(@RequestBody CarpetaRequest carpetaRequest){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.carpetasService.saveCarpetas(carpetaRequest));
    }
}
