package com.ramos.backend_barber.dto.clienteDTO;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record ClienteRequestDTO (
        @NotBlank(message = "El nombre es obligatorio")
        String nombre,

        @NotBlank(message = "El nombre es obligatorio")
        String apellido,

        @NotBlank(message = "El email es obligatorio")
        @Email(message = "El formato de email debe ser validio")
        String email,

        String telefono
){


}
