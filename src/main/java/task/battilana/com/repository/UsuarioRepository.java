package task.battilana.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import task.battilana.com.entity.UsuariosEntity;

public interface UsuarioRepository extends JpaRepository<UsuariosEntity, Long> {
}
