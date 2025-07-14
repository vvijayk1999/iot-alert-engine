package io.github.vvijayk1999.iot_alert_engine.contoller;

import io.github.vvijayk1999.iot_alert_engine.model.Device;
import io.github.vvijayk1999.iot_alert_engine.service.DeviceService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<Device> create(@RequestBody Device device) {
        return ResponseEntity.ok(deviceService.create(device));
    }

    @GetMapping
    public ResponseEntity<List<Device>> getAll() {
        return ResponseEntity.ok(deviceService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Device> getById(@PathVariable String id) {
        return deviceService.getById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Device> updateThresholds(
            @PathVariable String id,
            @RequestBody Map<String, Double> thresholds
    ) {
        return ResponseEntity.ok(deviceService.update(id, thresholds));
    }
}

