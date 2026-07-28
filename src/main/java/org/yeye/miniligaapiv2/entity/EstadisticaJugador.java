package org.yeye.miniligaapiv2.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
public class EstadisticaJugador {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer goles;
    private Integer asistencias;
    private Integer amarillas;
    private Integer rojas;

    @ManyToOne
    @JoinColumn( name = "jugador_id")
    @JsonBackReference
    private Jugador jugador;
    @ManyToOne
    @JoinColumn(name = "torneo_id")
    @JsonBackReference
    private Torneo torneo;
}
