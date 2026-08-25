package org.yeye.miniligaapiv2.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yeye.miniligaapiv2.enums.FasePartido;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Partido {

    @Id
    @GeneratedValue( strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipoA_id")
    private Equipo equipoA;
    @ManyToOne
    @JoinColumn(name = "equipoB_id")
    private Equipo equipoB;

    @ManyToOne
    @JoinColumn( name = "torneo_id")
    private Torneo torneo;

    @Enumerated(EnumType.STRING)
    private FasePartido fase;

    private Integer GolequipoA;
    private Integer GolequipoB;
    private LocalDate fecha;
    private Boolean finalizado;
}
