package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Reporte;
import com.poli.ingesoft.transport.persistence.mongo.ReporteDocument;
import com.poli.ingesoft.transport.persistence.repository.ReporteRepository;
import com.poli.ingesoft.transport.service.ReporteService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class ReporteServiceImpl implements ReporteService {

    private final ReporteRepository reporteRepository;

    @Autowired
    public ReporteServiceImpl(ReporteRepository reporteRepository) {
        this.reporteRepository = reporteRepository;
    }


    @Override
    public Reporte obtenerReporte(String reporteId) {

        ReporteDocument reporteDocument = reporteRepository.findById(reporteId).orElse(null);
        if (reporteDocument == null) {
            log.error("Reporte no encontrado");
            return null;
        }
        Reporte reporte = new Reporte();
        reporte.setDescripcionReporte(reporteDocument.getDescripcionReporte());
        reporte.setTipoReporte(reporteDocument.getTipoReporte());
        reporte.setDatos(reporteDocument.getDatos());

        return reporte;
    }

    @Override
    public String guardarReporte(Reporte reporte) {

        ReporteDocument reporteDocument = new ReporteDocument();
        reporteDocument.setDescripcionReporte(reporte.getDescripcionReporte());
        reporteDocument.setTipoReporte(reporte.getTipoReporte());
        reporteDocument.setDatos(reporte.getDatos());
        reporteRepository.save(reporteDocument);

        return reporteDocument.getId();
    }
}
