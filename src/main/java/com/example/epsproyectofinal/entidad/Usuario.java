package com.example.epsproyectofinal.entidad;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
@Inheritance(strategy= InheritanceType.TABLE_PER_CLASS )
@MappedSuperclass
@Getter
@Setter
//@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)

public class Usuario implements Serializable {
    @Id
    @EqualsAndHashCode.Include
    @Column(name="idUsuario", length = 10, nullable = false)
    private String idUsuario;

    @Column(name="contraseña", length = 20, nullable = false)
    private String contraseña;

    @Column(name="email", length = 50, unique = true)
    private String email;

    @Enumerated(EnumType.STRING)
    @Column(name = "tipoUsuario", length = 10, nullable = false)
    private TipoUsuario tipoUsuario;

}