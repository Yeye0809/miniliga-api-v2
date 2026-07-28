package org.yeye.miniligaapiv2.entity;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yeye.miniligaapiv2.enums.Posicion;

import java.util.List;

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
    private Posicion posicion;

    @ManyToOne
    @JoinColumn(name = "equipo_id")
    @JsonManagedReference
    private Equipo equipo;

    @OneToMany( mappedBy = "jugador")
    @JsonManagedReference
    private List<EstadisticaJugador> estadisticaJugadores;

}
