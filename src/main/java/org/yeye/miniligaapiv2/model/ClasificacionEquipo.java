package org.yeye.miniligaapiv2.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.yeye.miniligaapiv2.entity.Equipo;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ClasificacionEquipo {
    private Equipo equipo;
    private int puntos;
    private int golesFavor;
    private int golesContra;

    public int diferenciaDeGoles(){
        return golesFavor - golesContra;
    }

}
