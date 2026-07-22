package com.ramos.backend_barber.mapper.cliente;

import com.ramos.backend_barber.dto.clienteDTO.ClienteRequestDTO;
import com.ramos.backend_barber.dto.clienteDTO.ClienteResponseDTO;
import com.ramos.backend_barber.entity.ClienteEntity;
import org.springframework.stereotype.Component;

@Component
public class ClienteMapper {

    // De entidad a vista (FrontEnd) o respuesta de endpoint
    public ClienteResponseDTO toResponseDto(ClienteEntity cliente){
        if(cliente == null) return null;

        return new ClienteResponseDTO(
                cliente.getUuidCliente(),
                cliente.getNombre(),
                cliente.getApellido(),
                cliente.getEmail(),
                cliente.getTelefono()
        );
    }

    // De FrontEnd a guardar en BD
    public ClienteEntity toEntity(ClienteRequestDTO dto){
        if(dto == null) return null;

        ClienteEntity cliente = new ClienteEntity();
        cliente.setNombre(dto.nombre());
        cliente.setApellido(dto.apellido());
        cliente.setEmail(dto.email());
        cliente.setTelefono(dto.telefono());

        return cliente;
    }
}
