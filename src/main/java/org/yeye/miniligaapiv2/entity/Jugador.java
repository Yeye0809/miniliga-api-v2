package org.yeye.miniligaapiv2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private String id;
    private String nombre;
    private String apellido;
    private String telefono;
    private Integer goles;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "equipo_id")
    @JsonManagedReference
    private Equipo equipo;

}
