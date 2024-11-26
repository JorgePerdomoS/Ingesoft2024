package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Emergencia;
import com.poli.ingesoft.transport.domain.Sensor;
import com.poli.ingesoft.transport.domain.Vehiculo;
import com.poli.ingesoft.transport.persistence.mongo.EmergenciaDocument;
import com.poli.ingesoft.transport.persistence.mongo.SensorDocument;
import com.poli.ingesoft.transport.persistence.mongo.VehiculoDocument;
import com.poli.ingesoft.transport.persistence.repository.EmergenciaRepository;
import com.poli.ingesoft.transport.service.EmergenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmergenciaServiceImpl implements EmergenciaService {

    private final EmergenciaRepository emergenciaRepository;

    @Autowired
    public EmergenciaServiceImpl(EmergenciaRepository emergenciaRepository) {
        this.emergenciaRepository=emergenciaRepository;
    }

    @Override
    public Emergencia obtenerEmergencia(String emergenciaId) {
        return null;
    }

    @Override
    public String guardarEmergencia(Emergencia emergencia) {
        EmergenciaDocument emergenciaDocument=new EmergenciaDocument();
        emergenciaDocument.setTipoEmergencia(emergencia.getTipoEmergencia());
        List<SensorDocument> sensorDocuments=new ArrayList<>();
        emergencia.getDatosSensor().forEach(sensor -> {
            SensorDocument sensorDocument=new SensorDocument();
            sensorDocument.setValor(sensor.getValor());
            sensorDocument.setTipo(sensor.getTipo());
            sensorDocuments.add(sensorDocument);
        });
        emergenciaDocument.setDatosSensor(sensorDocuments);
        VehiculoDocument vehiculoDocument = new VehiculoDocument();
        vehiculoDocument.setModelo(emergencia.getVehiculo().getModelo());
        vehiculoDocument.setCapacidadCarga(emergencia.getVehiculo().getCapacidadCarga());
        vehiculoDocument.setPlaca(emergencia.getVehiculo().getPlaca());

        List<SensorDocument> sensorDocumentsVehiculo=new ArrayList<>();
        emergencia.getVehiculo().getSensoresConfig().forEach(sensor -> {
            SensorDocument sensorDocument=new SensorDocument();
            sensorDocument.setValor(sensor.getValor());
            sensorDocument.setTipo(sensor.getTipo());
            sensorDocumentsVehiculo.add(sensorDocument);
        });
        vehiculoDocument.setSensoresConfig(sensorDocumentsVehiculo);
        emergenciaDocument.setVehiculo(vehiculoDocument);
        emergenciaRepository.save(emergenciaDocument);

        return emergenciaDocument.getId();
    }
}
