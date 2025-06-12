package task.battilana.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import task.battilana.com.entity.TareasEntity;

import java.util.List;

public interface TareasRepository extends JpaRepository<TareasEntity, Long> {


    @Query("SELECT count(te) " +
            "FROM TareasEntity te " +
            "WHERE te.estadoEnum = 'PENDIENTE'")
    int countByEstadoEnumPendiente();

    @Query("SELECT count(te) " +
            "FROM TareasEntity te " +
            "WHERE te.estadoEnum = 'TERMINADO'")
    int countByEstadoEnumTerminado();

    @Query("SELECT count(T) FROM TareasEntity T ")
    int countByEstadoEnumTotales();

    @Query("SELECT T FROM TareasEntity T " +
            "WHERE T.estadoEnum = 'PENDIENTE' " +
            "ORDER BY T.fechaCreacion desc")
    List<TareasEntity> listadoTareasPorPendiente();

    @Query("SELECT T FROM TareasEntity T " +
            "WHERE T.estadoEnum = 'TERMINADO' " +
            "ORDER BY T.fechaCreacion desc")
    List<TareasEntity> listadoTareasPorTerminado();

    @Query("SELECT T FROM TareasEntity T " +
            "ORDER BY T.fechaCreacion desc")
    List<TareasEntity> findAll();
}
