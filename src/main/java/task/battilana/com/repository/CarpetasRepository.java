package task.battilana.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import task.battilana.com.entity.CarpetasEntity;

import java.util.List;

public interface CarpetasRepository extends JpaRepository<CarpetasEntity, Long> {

    @Query("SELECT C " +
            "FROM CarpetasEntity C " +
            "INNER JOIN UsuariosEntity U ON U.idUsuarios = C.idUsuario.idUsuarios " +
            "WHERE C.idUsuario.idUsuarios =:idUsuario"
    )
    List<CarpetasEntity> findCarpetaByUsuario(@Param("idUsuario") Long idUsuario);
}
