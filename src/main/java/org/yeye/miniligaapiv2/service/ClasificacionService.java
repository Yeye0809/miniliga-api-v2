package org.yeye.miniligaapiv2.service;

import org.yeye.miniligaapiv2.entity.Equipo;
import org.yeye.miniligaapiv2.entity.Grupo;

import java.util.List;

public interface ClasificacionService {

    List<Equipo> obtenerClasificados(Grupo grupo);;
}
