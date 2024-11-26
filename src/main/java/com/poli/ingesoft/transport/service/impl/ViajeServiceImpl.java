package com.poli.ingesoft.transport.service.impl;

import com.poli.ingesoft.transport.domain.Carga;
import com.poli.ingesoft.transport.domain.Sensor;
import com.poli.ingesoft.transport.domain.Vehiculo;
import com.poli.ingesoft.transport.domain.Viaje;
import com.poli.ingesoft.transport.persistence.mongo.CargaDocument;
import com.poli.ingesoft.transport.persistence.mongo.SensorDocument;
import com.poli.ingesoft.transport.persistence.mongo.VehiculoDocument;
import com.poli.ingesoft.transport.persistence.mongo.ViajeDocument;
import com.poli.ingesoft.transport.persistence.repository.ViajeRepository;
import com.poli.ingesoft.transport.service.ViajeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ViajeServiceImpl implements ViajeService {

    private final ViajeRepository viajeRepository;

    @Autowired
    public ViajeServiceImpl(ViajeRepository viajeRepository) {
        this.viajeRepository = viajeRepository;
    }


    @Override
    public Viaje obtenerViaje(String viajeId) {
        ViajeDocument viajeDocument = viajeRepository.findById(viajeId).orElse(null);
        if (viajeDocument == null){
            log.error("Viaje " + viajeId + " no encontrado");
            return null;
        }
        Viaje viaje = new Viaje();
        Carga carga = new Carga();
        carga.setTemperatura(viajeDocument.getCarga().getTemperatura());
        carga.setDescripcion(viajeDocument.getCarga().getDescripcion());
        carga.setRecepcionado(viajeDocument.getCarga().isRecepcionado());
        carga.setEstado(viajeDocument.getCarga().getEstado());
        carga.setDireccion(viajeDocument.getCarga().getDireccion());
        carga.setConductor(viajeDocument.getCarga().getConductor());
        viaje.setCarga(carga);

        viaje.setRuta(viajeDocument.getRuta());

        Vehiculo vehiculo = new Vehiculo();
        vehiculo.setCapacidadCarga(viajeDocument.getVehiculo().getCapacidadCarga());
        vehiculo.setTipo(viajeDocument.getVehiculo().getTipo());
        vehiculo.setPlaca(viajeDocument.getVehiculo().getPlaca());
        vehiculo.setModelo(viajeDocument.getVehiculo().getModelo());

        List<Sensor> sensores = new ArrayList<>();

        viajeDocument.getVehiculo().getSensoresConfig().forEach(sensor -> {
            Sensor sensor1 = new Sensor();
            sensor1.setValor(sensor.getValor());
            sensor1.setTipo(sensor.getTipo());
            sensores.add(sensor1);
        });

        vehiculo.setSensoresConfig(sensores);
        viaje.setVehiculo(vehiculo);
        return viaje;
    }

    @Override
    public String guardarViaje(Viaje viaje) {

        ViajeDocument viajeDocument = new ViajeDocument();

        CargaDocument carga = new CargaDocument();
        carga.setTemperatura(viaje.getCarga().getTemperatura());
        carga.setDescripcion(viaje.getCarga().getDescripcion());
        carga.setRecepcionado(viaje.getCarga().isRecepcionado());
        carga.setEstado(viaje.getCarga().getEstado());
        carga.setDireccion(viaje.getCarga().getDireccion());
        carga.setConductor(viaje.getCarga().getConductor());
        viajeDocument.setCarga(carga);

        viajeDocument.setRuta(viaje.getRuta());

        VehiculoDocument vehiculo = new VehiculoDocument();
        vehiculo.setCapacidadCarga(viaje.getVehiculo().getCapacidadCarga());
        vehiculo.setTipo(viaje.getVehiculo().getTipo());
        vehiculo.setPlaca(viaje.getVehiculo().getPlaca());
        vehiculo.setModelo(viaje.getVehiculo().getModelo());

        List<SensorDocument> sensores = new ArrayList<>();

        viaje.getVehiculo().getSensoresConfig().forEach(sensor -> {
            SensorDocument sensor1 = new SensorDocument();
            sensor1.setValor(sensor.getValor());
            sensor1.setTipo(sensor.getTipo());
            sensores.add(sensor1);
        });

        vehiculo.setSensoresConfig(sensores);
        viajeDocument.setVehiculo(vehiculo);

        viajeRepository.save(viajeDocument);
        return viajeDocument.getId();
    }
}
