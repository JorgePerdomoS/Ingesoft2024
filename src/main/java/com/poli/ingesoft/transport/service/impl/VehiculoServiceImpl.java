package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Sensor;
import com.poli.ingesoft.transport.domain.Vehiculo;
import com.poli.ingesoft.transport.persistence.mongo.SensorDocument;
import com.poli.ingesoft.transport.persistence.mongo.VehiculoDocument;
import com.poli.ingesoft.transport.persistence.repository.VehiculoRepository;
import com.poli.ingesoft.transport.service.VehiculoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class VehiculoServiceImpl implements VehiculoService {

    private final VehiculoRepository vehiculoRepository;

    public VehiculoServiceImpl(VehiculoRepository vehiculoRepository) {
        this.vehiculoRepository = vehiculoRepository;
    }


    @Override
    public void actualizarUbicacion() {

    }

    @Override
    public void reportarEstado() {

    }

    @Override
    public Vehiculo obtenerVehiculo(String placa) {
        log.info("Consultando vehiculo");
        VehiculoDocument vehiculoDocument = vehiculoRepository.findByPlaca(placa).orElse(null);
        if (vehiculoDocument == null) {
            log.error("Vehiculo no existe");
        }
        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setPlaca(vehiculoDocument.getPlaca());
        vehiculo.setTipo(vehiculoDocument.getTipo());
        vehiculo.setModelo(vehiculoDocument.getModelo());
        vehiculo.setCapacidadCarga(vehiculoDocument.getCapacidadCarga());

        List<Sensor> sensores = new ArrayList<>();

        vehiculoDocument.getSensoresConfig().forEach(sensorDocument -> {
            Sensor sensor = new Sensor();
            sensor.setTipo(sensorDocument.getTipo());
            sensor.setValor(sensorDocument.getValor());
            sensores.add(sensor);
        });
        vehiculo.setSensoresConfig(sensores);

        return vehiculo;
    }

    @Override
    public void guardarVehiculo(Vehiculo vehiculo) {
        log.info("Registrando vehiculo");
        VehiculoDocument vehiculoDocument = vehiculoRepository.findByPlaca(vehiculo.getId()).orElse(null);
        if (vehiculoDocument != null) {
            log.error("Vehiculo ya existe");
        }
        vehiculoDocument = new VehiculoDocument();
        vehiculoDocument.setTipo(vehiculo.getTipo());
        vehiculoDocument.setPlaca(vehiculo.getPlaca());
        vehiculoDocument.setModelo(vehiculo.getModelo());
        vehiculoDocument.setCapacidadCarga(vehiculo.getCapacidadCarga());

        List<SensorDocument> sensores = new ArrayList<>();

        vehiculo.getSensoresConfig().forEach(sensor -> {
            SensorDocument sensorDocument = new SensorDocument();
            sensorDocument.setTipo(sensor.getTipo());
            sensorDocument.setValor(sensor.getValor());
            sensores.add(sensorDocument);
        });

        vehiculoDocument.setSensoresConfig(sensores);

        log.info("Guardando vehiculo");
        vehiculoRepository.save(vehiculoDocument    );
    }
}
