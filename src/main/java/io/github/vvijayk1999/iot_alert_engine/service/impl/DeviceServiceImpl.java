package io.github.vvijayk1999.iot_alert_engine.service.impl;

import io.github.vvijayk1999.iot_alert_engine.model.Device;
import io.github.vvijayk1999.iot_alert_engine.repository.DeviceRepository;
import io.github.vvijayk1999.iot_alert_engine.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DeviceServiceImpl implements DeviceService {

    private final DeviceRepository repo;

    @Override
    public Device create(Device device) {
        return repo.save(device);
    }

    @Override
    public List<Device> getAll() {
        return repo.findAll();
    }

    @Override
    public Optional<Device> getById(String id) {
        return repo.findById(id);
    }

    @Override
    public Device update(String id, Map<String, Double> thresholds) {
        Device device = repo.findById(id)
                .orElseThrow(() -> new RuntimeException("Device not found"));
        device.setThresholds(thresholds);
        return repo.save(device);
    }
}

