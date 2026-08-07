package com.ramos.backend_barber.controller;

import com.ramos.backend_barber.dto.clienteDTO.ClienteRequestDTO;
import com.ramos.backend_barber.dto.clienteDTO.ClienteResponseDTO;
import com.ramos.backend_barber.service.clienteService.ClienteService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/api/v1/clientes")
public class ClienteController {

    private final ClienteService clienteService;

    public ClienteController(ClienteService clienteService){
        this.clienteService = clienteService;
    }

    @PostMapping
    public ResponseEntity<ClienteResponseDTO> crearCliente(@Valid @RequestBody ClienteRequestDTO requestDTO){

        ClienteResponseDTO clienteCreado = clienteService.crearCliente(requestDTO);

        return ResponseEntity.status(HttpStatus.CREATED).body(clienteCreado);
    }

    public ResponseEntity<ClienteResponseDTO> obtenerClientePorUuid(@PathVariable UUID uuid){
        ClienteResponseDTO cliente = clienteService.obtenerPorUuid(uuid);

        return ResponseEntity.ok(cliente);
    }
}
