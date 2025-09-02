package task.battilana.com.dto;

public record UsuarioResponse(
        String nombres,
        String apellidos,
        String correo,
        Boolean estado,
        String roles
) {
}
