package task.battilana.com.dto;

public record UsuarioRequest(
        String nombres,
        String apellidos,
        String correo,
        String password
) {
}
