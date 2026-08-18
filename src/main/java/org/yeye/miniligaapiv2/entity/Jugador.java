package org.yeye.miniligaapiv2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Jugador {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;
    private String telefono;
    private String posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    @JsonManagedReference
    private Equipo equipo;

    @OneToMany( mappedBy = "jugador")
    @JsonManagedReference
    private List<EstadisticaJugador> estadisticaJugadores;

}
