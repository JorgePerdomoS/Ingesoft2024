package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Carga;
import com.poli.ingesoft.transport.persistence.mongo.CargaDocument;
import com.poli.ingesoft.transport.persistence.repository.CargaRepository;
import com.poli.ingesoft.transport.service.CargaService;
import com.poli.ingesoft.transport.util.enums.GlobalState;
import com.poli.ingesoft.transport.util.enums.ReportState;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CargaServiceImpl implements CargaService {

    private static final Logger log = LoggerFactory.getLogger(CargaServiceImpl.class);
    private final CargaRepository cargaRepository;

    @Autowired
    public CargaServiceImpl(CargaRepository cargaRepository) {
        this.cargaRepository = cargaRepository;
    }

    @Override
    public Integer actualizarEstado(String cargaId) {
        CargaDocument cargaDocument = cargaRepository.findById(cargaId).orElse(null);
        if (cargaDocument == null) {
            log.error("carga no encontrada");
            return GlobalState.NOT_EXIST.getValue();
        }
        cargaDocument.setEstado(ReportState.RECEPCION.getValue());
        cargaDocument.setRecepcionado(true);
        cargaRepository.save(cargaDocument);

        return GlobalState.OK.getValue();
    }


    @Override
    public List<Carga> obtenerCargas() {
        List<CargaDocument> cargasDocument = cargaRepository.findAll();
        List<Carga> cargas = new ArrayList<>();
        cargasDocument.forEach(cargaDocument -> {
            Carga carga = new Carga();
            carga.setConductor(cargaDocument.getConductor());
            carga.setDescripcion(cargaDocument.getDescripcion());
            carga.setEstado(cargaDocument.getEstado());
            carga.setRecepcionado(cargaDocument.isRecepcionado());
            carga.setDireccion(cargaDocument.getDireccion());
            carga.setTemperatura(cargaDocument.getTemperatura());
            cargas.add(carga);
        });

        return cargas;
    }

    @Override
    public String guardarCarga(Carga carga) {
        CargaDocument cargaDocument = new CargaDocument();
        cargaDocument.setDescripcion(carga.getDescripcion());
        cargaDocument.setEstado(ReportState.ENTREGA.getValue());
        cargaDocument.setTemperatura(carga.getTemperatura());
        cargaDocument.setConductor(carga.getConductor());
        cargaDocument.setDireccion(carga.getDireccion());
        cargaDocument.setRecepcionado(false);
        cargaRepository.save(cargaDocument);
        return cargaDocument.getId();
    }
}
