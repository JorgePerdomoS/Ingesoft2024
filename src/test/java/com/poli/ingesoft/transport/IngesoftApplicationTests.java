package com.poli.ingesoft.transport;

import com.poli.ingesoft.transport.domain.Carga;
import com.poli.ingesoft.transport.persistence.mongo.CargaDocument;
import com.poli.ingesoft.transport.persistence.repository.CargaRepository;
import com.poli.ingesoft.transport.service.impl.CargaServiceImpl;
import com.poli.ingesoft.transport.util.enums.GlobalState;
import com.poli.ingesoft.transport.util.enums.ReportState;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

@SpringBootTest
class IngesoftApplicationTests {

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private CargaServiceImpl cargaService;

    @Test
    void actualizarEstado_cargaExistente_estadoActualizado() {
        // Arrange
        CargaDocument cargaDocument = new CargaDocument();
        cargaDocument.setEstado(ReportState.ENTREGA.getValue());
        cargaRepository.save(cargaDocument);

        // Act
        Integer result = cargaService.actualizarEstado(cargaDocument.getId());

        // Assert
        assertThat(result).isEqualTo(GlobalState.OK.getValue());
        assertThat(cargaDocument.getEstado()).isEqualTo(ReportState.RECEPCION.getValue());
        assertThat(cargaDocument.isRecepcionado()).isTrue();
        verify(cargaRepository).findById(cargaDocument.getId());
        verify(cargaRepository).save(cargaDocument);
    }

    @Test
    void actualizarEstado_cargaNoExistente_retornaNotExist() {
        // Arrange
        String cargaId = "123";
        when(cargaRepository.findById(cargaId)).thenReturn(Optional.empty());

        // Act
        Integer result = cargaService.actualizarEstado(cargaId);

        // Assert
        assertThat(result).isEqualTo(GlobalState.NOT_EXIST.getValue());
        verify(cargaRepository).findById(cargaId);
        verify(cargaRepository, never()).save(any());
    }

    @Test
    void obtenerCargas_retornaListaCargas() {
        // Arrange
        CargaDocument cargaDocument = new CargaDocument();
        cargaDocument.setDescripcion("Carga 1");
        cargaDocument.setEstado(ReportState.ENTREGA.getValue());
        cargaDocument.setRecepcionado(false);
        cargaDocument.setDireccion("Calle 123");
        cargaDocument.setTemperatura("20");
        cargaDocument.setConductor("Juan Pérez");
        when(cargaRepository.findAll()).thenReturn(List.of(cargaDocument));

        // Act
        List<Carga> cargas = cargaService.obtenerCargas();

        // Assert
        assertThat(cargas).hasSize(1);
        Carga carga = cargas.get(0);
        assertThat(carga.getDescripcion()).isEqualTo("Carga 1");
        assertThat(carga.getEstado()).isEqualTo(ReportState.ENTREGA.getValue());
        assertThat(carga.isRecepcionado()).isFalse();
        assertThat(carga.getDireccion()).isEqualTo("Calle 123");
        assertThat(carga.getTemperatura()).isEqualTo(20.0);
        assertThat(carga.getConductor()).isEqualTo("Juan Pérez");
        verify(cargaRepository).findAll();
    }

    @Test
    void guardarCarga_guardaCargaYRetornaId() {
        // Arrange
        Carga carga = new Carga();
        carga.setDescripcion("Nueva Carga");
        carga.setTemperatura("25.0");
        carga.setConductor("Ana López");
        carga.setDireccion("Avenida Principal");

        CargaDocument cargaDocument = new CargaDocument();
        cargaDocument.setId("456");
        when(cargaRepository.save(any(CargaDocument.class))).thenReturn(cargaDocument);

        // Act
        String id = cargaService.guardarCarga(carga);

        // Assert
        assertThat(id).isEqualTo("456");
        verify(cargaRepository).save(any(CargaDocument.class));
    }
}
