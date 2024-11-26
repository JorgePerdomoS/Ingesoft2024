package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Desempeño;
import com.poli.ingesoft.transport.persistence.mongo.UsuarioDocument;
import com.poli.ingesoft.transport.persistence.mongo.DesempeñoDocument;
import com.poli.ingesoft.transport.persistence.repository.UsuarioRepository;
import com.poli.ingesoft.transport.persistence.repository.DesempeñoRepository;
import com.poli.ingesoft.transport.service.DesempeñoService;
import com.poli.ingesoft.transport.util.enums.GlobalState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DesempeñoServiceImpl implements DesempeñoService {

    private final DesempeñoRepository desempeñoRepository;
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public DesempeñoServiceImpl(DesempeñoRepository desempeñoRepository, UsuarioRepository usuarioRepository) {
        this.desempeñoRepository = desempeñoRepository;
        this.usuarioRepository = usuarioRepository;
    }

    @Override
    public List<Desempeño> obtenerDesempeño(String documentoConductor) {
        List<DesempeñoDocument> desempeñoDocumentList = desempeñoRepository.findByConductorId(documentoConductor);
        List<Desempeño> desempeños = new ArrayList<>();
        desempeñoDocumentList.forEach(desempeñoDocument -> {
            Desempeño desempeño = new Desempeño();
            desempeño.setConductorId(desempeñoDocument.getConductorId());
            desempeño.setCalificacion(desempeñoDocument.getCalificacion());
            desempeños.add(desempeño);
        });

        return desempeños;
    }

    @Override
    public Integer guardarDesempeño(Desempeño desempeño) {
        UsuarioDocument usuarioDocument = usuarioRepository.findByDocumento(desempeño.getConductorId()).orElse(null);
        if (usuarioDocument == null) {
            log.error("El conductor no existe.");
            return GlobalState.NOT_EXIST.getValue();
        }
        DesempeñoDocument desempeñoDocument = new DesempeñoDocument();
        desempeñoDocument.setCalificacion(desempeño.getCalificacion());
        desempeñoDocument.setConductorId(desempeño.getConductorId());
        desempeñoRepository.save(desempeñoDocument);

        return GlobalState.OK.getValue();
    }
}
