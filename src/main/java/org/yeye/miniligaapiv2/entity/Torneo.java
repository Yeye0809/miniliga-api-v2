package org.yeye.miniligaapiv2.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Torneo {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String descripcion;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;

    @OneToMany(mappedBy = "torneo")
    @JsonManagedReference
    private List<Equipo> equipos;
    @OneToMany(mappedBy = "torneo")
    @JsonManagedReference
    private List<Partido> partidos;

    @OneToMany( mappedBy = "torneo")
    @JsonManagedReference
    private List<EstadisticaJugador> estadisticaJugadores;
    private Boolean activo;


}
