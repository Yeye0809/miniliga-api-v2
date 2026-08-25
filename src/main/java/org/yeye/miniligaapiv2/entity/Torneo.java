package org.yeye.miniligaapiv2.entity;


import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Builder
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

    private Boolean activo;

    public void agregarPartido(Partido partido){
        partidos.add(partido);
        partido.setTorneo(this);
    }

}
