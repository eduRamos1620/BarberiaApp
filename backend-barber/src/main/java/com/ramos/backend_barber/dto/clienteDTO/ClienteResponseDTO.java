package com.ramos.backend_barber.dto.clienteDTO;

import java.util.UUID;

public record ClienteResponseDTO(UUID uuidCliente, String nombre, String apellido, String email, String telefono){

}
