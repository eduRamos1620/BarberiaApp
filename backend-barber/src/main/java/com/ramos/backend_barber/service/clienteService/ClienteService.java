package com.ramos.backend_barber.service.clienteService;

import com.ramos.backend_barber.dto.clienteDTO.ClienteRequestDTO;
import com.ramos.backend_barber.dto.clienteDTO.ClienteResponseDTO;
import com.ramos.backend_barber.entity.ClienteEntity;
import com.ramos.backend_barber.mapper.cliente.ClienteMapper;
import com.ramos.backend_barber.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class ClienteService {

    private final ClienteRepository  clienteRepository;
    private final ClienteMapper clienteMapper;

    public ClienteService(ClienteRepository clienteRepository, ClienteMapper clienteMapper) {
        this.clienteRepository = clienteRepository;
        this.clienteMapper = clienteMapper;
    }

    @Transactional
    public ClienteResponseDTO crearCliente(ClienteRequestDTO dto){
        ClienteEntity cliente = clienteMapper.toEntity(dto);
        ClienteEntity clienteGuardado = clienteRepository.save(cliente);

        return clienteMapper.toResponseDto(clienteGuardado);
    }

    public ClienteResponseDTO obtenerPorUuid(UUID uuidCliente){
        return clienteRepository.findByUuidCliente(uuidCliente)
                .map(clienteMapper::toResponseDto)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));
    }
}
