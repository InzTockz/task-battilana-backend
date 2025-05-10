package task.battilana.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import task.battilana.com.entity.TareasEntity;

public interface TareasRepository extends JpaRepository<TareasEntity, Long> {


    @Query("SELECT count(te) " +
            "FROM TareasEntity te " +
            "WHERE te.estadoEnum = 'PENDIENTE'")
    int countByEstadoEnumPendiente();

    @Query("SELECT count(te) " +
            "FROM TareasEntity te " +
            "WHERE te.estadoEnum = 'TERMINADO'")
    int countByEstadoEnumTerminado();
}
