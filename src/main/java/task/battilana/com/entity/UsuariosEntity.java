package task.battilana.com.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "tbl_usuarios")
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UsuariosEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_usuarios")
    private Long idUsuarios;
    @Column(name = "nombres")
    private String nombres;
    @Column(name = "correo")
    private String correo;
}
