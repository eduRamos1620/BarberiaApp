package com.ramos.backend_barber.entity;

import com.ramos.backend_barber.enums.Rol;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.util.UUID;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
@Entity
@Table(name = "clientes")
public class ClienteEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idCliente;

    @Builder.Default
    @Column(nullable = false, unique = true, updatable = false)
    private UUID uuidCliente = UUID.randomUUID();

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String apellido;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String telefono;

    @Builder.Default
    @Enumerated(EnumType.STRING)
    @NotNull
    @Column(nullable = false)
    private Rol rol= Rol.CLIENTE;

    @PrePersist
    public void prePersist(){
        if(this.rol == null){
            this.rol = Rol.CLIENTE;
        }
    }
}
