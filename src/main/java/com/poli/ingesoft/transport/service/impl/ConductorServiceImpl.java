package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Conductor;
import com.poli.ingesoft.transport.domain.Reporte;
import com.poli.ingesoft.transport.persistence.mongo.ConductorDocument;
import com.poli.ingesoft.transport.persistence.mongo.DesempeñoDocument;
import com.poli.ingesoft.transport.persistence.mongo.ReporteDocument;
import com.poli.ingesoft.transport.persistence.repository.ConductorRepository;
import com.poli.ingesoft.transport.persistence.repository.DesempeñoRepository;
import com.poli.ingesoft.transport.persistence.repository.ReporteRepository;
import com.poli.ingesoft.transport.service.ConductorService;
import com.poli.ingesoft.transport.util.enums.ReportState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class ConductorServiceImpl implements ConductorService {

    private final String ENTREGRADO_STATE = "Entregado";
    private final String RECEPCION_STATE = "Recibido";
    private final String EMERGENCIA_STATE = "Emergencia";

    private final ConductorRepository conductorRepository;
    private final DesempeñoRepository desempeñoRepository;
    private final ReporteRepository reporteRepository;

    public ConductorServiceImpl(ConductorRepository conductorRepository, DesempeñoRepository desempeñoRepository, ReporteRepository reporteRepository) {
        this.conductorRepository = conductorRepository;
        this.desempeñoRepository = desempeñoRepository;
        this.reporteRepository = reporteRepository;
    }

    @Override
    public Conductor obtenerConductor(String documento) {
        ConductorDocument conductorDocument = conductorRepository.findByDocumento(documento).orElse(null);
        if (conductorDocument == null) {
            log.error("El conductor ya existe.");
        }
        Conductor conductor = new Conductor();
        conductor.setDocumento(conductorDocument.getDocumento());
        conductor.setNombre(conductorDocument.getNombre());
        conductor.setRol(conductorDocument.getRol());
        conductor.setCalificacion(obtenerCalificacionTotal(conductorDocument.getDocumento()));

        return conductor;
    }

    @Override
    public void guardarConductor(Conductor conductor) {
        ConductorDocument conductorDocument = conductorRepository.findByDocumento(conductor.getDocumento()).orElse(null);
        if (conductorDocument != null) {
            log.error("El conductor ya existe.");
        }
        conductorDocument.setDocumento(conductor.getDocumento());
        conductorDocument.setNombre(conductor.getNombre());
        conductorDocument.setRol(conductor.getRol());
        conductorDocument.setContraseña(conductor.getContraseña());
        conductorDocument.setNombreUsuario(conductor.getNombreUsuario());
        conductorRepository.save(conductorDocument);
    }

    @Override
    public void generarReporte(Reporte reporte) {
        ReporteDocument reporteDocument = new ReporteDocument();
        reporteDocument.setDatos(reporte.getDatos());
        reporteDocument.setTipoReporte(reporte.getTipoReporte());
        if (Objects.equals(reporte.getTipoReporte().getValue(), ReportState.ENTREGA.getValue())){
            reporteDocument.setDescripcionReporte(ENTREGRADO_STATE);
        }
        if (Objects.equals(reporte.getTipoReporte().getValue(), ReportState.RECEPCION.getValue())){
            reporteDocument.setDescripcionReporte(RECEPCION_STATE);
        }
        if (Objects.equals(reporte.getTipoReporte().getValue(), ReportState.EMERGENCIA.getValue())){
            reporteDocument.setDescripcionReporte(EMERGENCIA_STATE);
        }
        reporteRepository.save(reporteDocument);
    }

    @Override
    public void consultarRuta() {

    }

    private double obtenerCalificacionTotal(String documentoConductor) {
        double calificacion = 0.0;
        int total = 0;
        List<DesempeñoDocument> desempeñoDocumentList = desempeñoRepository.findByConductorId(documentoConductor);
        for (DesempeñoDocument desempeño : desempeñoDocumentList) {
            calificacion = calificacion + desempeño.getCalificacion();
            total++;
        }
        calificacion = calificacion / total;
        return calificacion;
    }
}
