package org.yeye.miniligaapiv2.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Builder
@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Grupo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    @OneToMany( mappedBy = "grupo" )
    private List<Equipo> equipos = new ArrayList<>();

    public void agregarEquipo(Equipo equipo) {
        this.equipos.add(equipo);
        equipo.setGrupo(this);
    }
}
