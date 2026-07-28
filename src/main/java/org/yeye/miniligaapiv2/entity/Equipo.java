package org.yeye.miniligaapiv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Equipo {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;
    private String nombre;
    private String apellido;

    @OneToMany(mappedBy = "equipo")
    private List<Jugador> jugadores;

    @ManyToOne
    @JoinColumn(name = "torneo_id")
    private Torneo torneo;

    @OneToOne
    @JoinColumn(name = "entrenador_id")
    private Entrenador entrenador;
}
