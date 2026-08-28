package org.yeye.miniligaapiv2.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.Grupo;
import org.yeye.miniligaapiv2.entity.Partido;
import org.yeye.miniligaapiv2.model.ClasificacionEquipo;
import org.yeye.miniligaapiv2.repository.PartidoRepository;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

@Service
public class ClasificacionServiceImpl implements ClasificacionService {

    @Autowired
    private PartidoRepository partidoRepository;

    //obtiene la lista de los equipos clasificados a cuartos de final
    public List<Equipo> obtenerClasificados(Grupo grupo) {

        //se crea una lista que va a guardar los equipos clasificados según sus puntos y goles
        List<ClasificacionEquipo> clasificados = new ArrayList<>();

        //se recorre los equipos de cada grupo
        for( Equipo equipo : grupo.getEquipos() ){
            //calcularEstadisticas, retornar un equipo con los puntos, goles a favor y goles en contra
            ClasificacionEquipo estadisticas = calcularEstadisticas(equipo, grupo);
            clasificados.add(estadisticas);
        }

        // se ordenan los equipos
        clasificados.sort(
                //comparing ordena la lista segun los puntos(de menor a mayor)
                Comparator
                        .comparing(ClasificacionEquipo::getPuntos)
                        //se una reversed para cambiar el orden de los objetos de mayor a menor
                        .reversed()
                        //si hay equipos con los mismo puntos, se tienen en cuenta otros datos para comparar
                        .thenComparing(
                                ClasificacionEquipo::getGolesFavor,
                                //se utiliza reverseOrder para cambiar el orden de mayor a menor
                                //a diferencia de reversed, para tipos de datos primitivos(int, longn string)
                                Comparator.reverseOrder()
                        )
                        .thenComparing(
                                ClasificacionEquipo::diferenciaDeGoles,
                                Comparator.reverseOrder()
                        )
        );

        // con la lista ya ordenada, retornamos una nueva lista, con los 2 primeros equipos
        // que son los que clasificaron por grupo
        return clasificados.stream()
                .limit(2)
                .map(ClasificacionEquipo::getEquipo)
                .toList();
    }

    public ClasificacionEquipo calcularEstadisticas(Equipo equipo, Grupo grupo) {

        int puntos = 0;
        int golesFavor = 0;
        int golesContra = 0;

        // se obtiene la lista de los partidos por grupo
        List<Partido> partdos = partidoRepository.findByGrupoId(grupo.getId());

        for( Partido partido : partdos) {

            // se comprueba de que ese partido ya se haya jugado
            if( !partido.getFinalizado() ) {
                continue;
            }


            if( partido.getEquipoA().equals(equipo)){
                golesFavor += partido.getGolequipoA();
                golesContra += partido.getGolequipoB();

                if( partido.getGolequipoA() > partido.getGolequipoB() ){
                    puntos += 3;

                }else if( partido.getGolequipoA().equals(partido.getGolequipoB()) ){
                    puntos += 1;
                }
            }else if( partido.getEquipoB().equals(equipo) ){
                golesFavor += partido.getGolequipoB();
                golesContra += partido.getGolequipoA();

                if( partido.getGolequipoB() > partido.getGolequipoA() ){
                    puntos += 3;
                } else if (partido.getGolequipoB().equals(partido.getGolequipoA())) {
                    puntos += 1;
                }
            }

        }

        return new ClasificacionEquipo(equipo, puntos, golesFavor, golesContra);
    }
}
