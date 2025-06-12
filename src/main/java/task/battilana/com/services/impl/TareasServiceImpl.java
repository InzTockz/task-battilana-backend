package task.battilana.com.services.impl;

import org.springframework.boot.autoconfigure.web.format.DateTimeFormatters;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
import task.battilana.com.dto.request.TareaRequest;
import task.battilana.com.dto.response.TareaResponse;
import task.battilana.com.entity.EstadoEnum;
import task.battilana.com.entity.TareasEntity;
import task.battilana.com.entity.UsuariosEntity;
import task.battilana.com.mapper.TareaMapper;
import task.battilana.com.repository.TareasRepository;
import task.battilana.com.services.TareasService;

import javax.swing.text.DateFormatter;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class TareasServiceImpl implements TareasService {

    private final TareaMapper tareaMapper;
    private final TareasRepository tareasRepository;

    public TareasServiceImpl(TareaMapper tareaMapper, TareasRepository tareasRepository) {
        this.tareaMapper = tareaMapper;
        this.tareasRepository = tareasRepository;
    }

    @Override
    public List<TareaResponse> listado() {
        return this.tareaMapper.listadoTareaDto(this.tareasRepository.findAll());
    }

    @Override
    public TareaResponse registrar(TareaRequest tareaDto) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        TareasEntity tareasEntity = new TareasEntity();
        tareasEntity.setNombreTarea(tareaDto.nombreTarea());
        tareasEntity.setDescripcion(tareaDto.descripcion());
        tareasEntity.setFechaInicio(LocalDate.parse(tareaDto.fechaInicio(), dateTimeFormatter));
        tareasEntity.setFechaFin(LocalDate.parse(tareaDto.fechaFin(), dateTimeFormatter));
        UsuariosEntity usuariosEntity = new UsuariosEntity();
        usuariosEntity.setIdUsuarios(tareaDto.idUsuariosEntity());
        tareasEntity.setUsuariosEntity(usuariosEntity);

        return this.tareaMapper.tareaDtoResponse(this.tareasRepository.save(tareasEntity));
    }

    @Override
    public TareaResponse actualizar(Long id, TareaRequest tareaDto) {
        if(id!=null){
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            TareasEntity tareasEntity = new TareasEntity();
            tareasEntity.setIdTarea(id);
            tareasEntity.setNombreTarea(tareaDto.nombreTarea());
            tareasEntity.setDescripcion(tareaDto.descripcion());
            tareasEntity.setFechaInicio(LocalDate.parse(tareaDto.fechaInicio(), dateTimeFormatter));
            tareasEntity.setFechaFin(LocalDate.parse(tareaDto.fechaFin(), dateTimeFormatter));
            UsuariosEntity usuariosEntity = new UsuariosEntity();
            usuariosEntity.setIdUsuarios(tareaDto.idUsuariosEntity());
            tareasEntity.setUsuariosEntity(usuariosEntity);
            return this.tareaMapper.tareaDtoResponse(this.tareasRepository.save(tareasEntity));
        } else {
            return null;
        }
    }

    @Override
    public TareaResponse buscar(Long id) {
        return this.tareaMapper.tareaDtoResponse(this.tareasRepository.findById(id).get());
    }

    @Override
    public void eliminar(Long id) {
        this.tareasRepository.deleteById(id);
    }

    @Override
    public Integer contadorPendientes() {
        return this.tareasRepository.countByEstadoEnumPendiente();
    }

    @Override
    public Integer contadorTerminados() {
        return this.tareasRepository.countByEstadoEnumTerminado();
    }

    @Override
    public Integer contadorTotales() {
        return this.tareasRepository.countByEstadoEnumTotales();
    }

    @Override
    public void actualizarEstado(Long id) {
        if(id!=null){
            TareasEntity tareasEntity = this.tareasRepository.findById(id).get();
            tareasEntity.setEstadoEnum(EstadoEnum.TERMINADO);
            this.tareasRepository.save(tareasEntity);
        }
    }

    @Override
    public List<TareaResponse> listadoPorPendiente() {
        return this.tareaMapper.listadoTareaDto(this.tareasRepository.listadoTareasPorPendiente());
    }

    @Override
    public List<TareaResponse> listadoPorTerminado() {
        return this.tareaMapper.listadoTareaDto(this.tareasRepository.listadoTareasPorTerminado());
    }
}
