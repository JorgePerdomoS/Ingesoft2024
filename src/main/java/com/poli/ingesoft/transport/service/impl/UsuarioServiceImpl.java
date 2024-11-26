package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Usuario;
import com.poli.ingesoft.transport.domain.Reporte;
import com.poli.ingesoft.transport.persistence.mongo.UsuarioDocument;
import com.poli.ingesoft.transport.persistence.mongo.DesempeñoDocument;
import com.poli.ingesoft.transport.persistence.mongo.ReporteDocument;
import com.poli.ingesoft.transport.persistence.repository.UsuarioRepository;
import com.poli.ingesoft.transport.persistence.repository.DesempeñoRepository;
import com.poli.ingesoft.transport.persistence.repository.ReporteRepository;
import com.poli.ingesoft.transport.service.UsuarioService;
import com.poli.ingesoft.transport.util.enums.GlobalState;
import com.poli.ingesoft.transport.util.enums.ReportState;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Service
@Slf4j
public class UsuarioServiceImpl implements UsuarioService {

    private final String ENTREGRADO_STATE = "Entregado";
    private final String RECEPCION_STATE = "Recibido";
    private final String EMERGENCIA_STATE = "Emergencia";

    private final UsuarioRepository usuarioRepository;
    private final DesempeñoRepository desempeñoRepository;
    private final ReporteRepository reporteRepository;

    public UsuarioServiceImpl(UsuarioRepository usuarioRepository, DesempeñoRepository desempeñoRepository, ReporteRepository reporteRepository) {
        this.usuarioRepository = usuarioRepository;
        this.desempeñoRepository = desempeñoRepository;
        this.reporteRepository = reporteRepository;
    }

    @Override
    public Usuario obtenerConductor(String documento) {
        UsuarioDocument usuarioDocument = usuarioRepository.findByDocumento(documento).orElse(null);
        if (usuarioDocument == null) {
            log.error("El conductor no existe.");
            return null;
        }
        Usuario usuario = new Usuario();
        usuario.setDocumento(usuarioDocument.getDocumento());
        usuario.setNombre(usuarioDocument.getNombre());
        usuario.setRol(usuarioDocument.getRol());
        usuario.setCalificacion(obtenerCalificacionTotal(usuarioDocument.getDocumento()));

        return usuario;
    }

    @Override
    public Integer guardarConductor(Usuario usuario) {
        UsuarioDocument usuarioDocument = usuarioRepository.findByDocumento(usuario.getDocumento()).orElse(null);
        if (usuarioDocument != null) {
            log.error("El conductor ya existe.");
            return GlobalState.ALREADY_EXIST.getValue();
        }
        usuarioDocument = new UsuarioDocument();
        usuarioDocument.setDocumento(usuario.getDocumento());
        usuarioDocument.setNombre(usuario.getNombre());
        usuarioDocument.setRol(usuario.getRol());
        usuarioDocument.setContraseña(usuario.getContraseña());
        usuarioDocument.setNombreUsuario(usuario.getNombreUsuario());
        usuarioRepository.save(usuarioDocument);

        return GlobalState.OK.getValue();
    }

    @Override
    public void generarReporte(Reporte reporte) {
        ReporteDocument reporteDocument = new ReporteDocument();
        reporteDocument.setDatos(reporte.getDatos());
        reporteDocument.setTipoReporte(reporte.getTipoReporte());
        if (Objects.equals(reporte.getTipoReporte().getValue(), ReportState.ENTREGA.getValue())) {
            reporteDocument.setDescripcionReporte(ENTREGRADO_STATE);
        }
        if (Objects.equals(reporte.getTipoReporte().getValue(), ReportState.RECEPCION.getValue())) {
            reporteDocument.setDescripcionReporte(RECEPCION_STATE);
        }
        if (Objects.equals(reporte.getTipoReporte().getValue(), ReportState.EMERGENCIA.getValue())) {
            reporteDocument.setDescripcionReporte(EMERGENCIA_STATE);
        }
        reporteRepository.save(reporteDocument);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        List<UsuarioDocument> usuarios = usuarioRepository.findAll();
        List<Usuario> usuariosEncontrados = new ArrayList<>();

        usuarios.forEach(usuarioDocument -> {
            Usuario usuario = new Usuario();
            usuario.setNombreUsuario(usuarioDocument.getNombreUsuario());
            usuario.setDocumento(usuarioDocument.getDocumento());
            usuario.setRol(usuarioDocument.getRol());
            usuario.setCalificacion(usuarioDocument.getCalificacion());
            usuariosEncontrados.add(usuario);
        });

        return usuariosEncontrados;
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
