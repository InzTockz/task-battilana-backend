package task.battilana.com.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import task.battilana.com.dto.request.TareaRequest;
import task.battilana.com.dto.response.TareaResponse;
import task.battilana.com.entity.TareasEntity;
import task.battilana.com.services.TareasService;

import java.util.List;

@RestController
@RequestMapping("/v1/api/tareas")
@CrossOrigin("*")
public class TareasController {

    private final TareasService tareasService;

    public TareasController(TareasService tareasService) {
        this.tareasService = tareasService;
    }

    @GetMapping("/listar")
    public ResponseEntity<List<TareaResponse>> listado(){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.listado());
    }

    @PostMapping("/registrar")
    public ResponseEntity<TareaResponse> registrar(@RequestBody TareaRequest tareaDto){
        return ResponseEntity.status(HttpStatus.CREATED).body(this.tareasService.registrar(tareaDto));
    }

    @PutMapping("/actualizar/{idTarea}")
    public ResponseEntity<TareaResponse> actualizar (@PathVariable Long idTarea, @RequestBody TareaRequest tareaRequest){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.actualizar(idTarea, tareaRequest));
    }

    @GetMapping("/buscar/{idTarea}")
    public ResponseEntity<TareaResponse> buscar (@PathVariable Long idTarea){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.buscar(idTarea));
    }

    @DeleteMapping("/eliminar/{idTarea}")
    public ResponseEntity<Void> eliminar (@PathVariable Long idTarea){
        this.tareasService.eliminar(idTarea);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @GetMapping("/contador-pendientes")
    public ResponseEntity<Integer> contadorPendientes (){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.contadorPendientes());
    }

    @GetMapping("/contador-terminados")
    public ResponseEntity<Integer> contadorTerminados(){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.contadorTerminados());
    }

    @GetMapping("/contador-totales")
    public ResponseEntity<Integer> contadorTotales(){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.contadorTotales());
    }

    @PutMapping("/actualizar-estado/{idTarea}")
    public ResponseEntity<Void> actualizarEstado(@PathVariable Long idTarea){
        this.tareasService.actualizarEstado(idTarea);
        return ResponseEntity.status(HttpStatus.OK).build();
    }

    @GetMapping("/listado-pendientes")
    public ResponseEntity<List<TareaResponse>> listadoPendientes(){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.listadoPorPendiente());
    }

    @GetMapping("/listado-terminado")
    public ResponseEntity<List<TareaResponse>> listadoTerminados(){
        return ResponseEntity.status(HttpStatus.OK).body(this.tareasService.listadoPorTerminado());
    }
}
