package io.github.vvijayk1999.iot_alert_engine.service;

import io.github.vvijayk1999.iot_alert_engine.model.Device;

import java.util.List;
import java.util.Map;
import java.util.Optional;

public interface DeviceService {
    Device create(Device device);
    List<Device> getAll();
    Optional<Device> getById(String id);
    Device update(String id, Map<String, Double> thresholds);
}
