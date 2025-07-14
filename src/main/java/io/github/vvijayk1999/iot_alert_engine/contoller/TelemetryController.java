package io.github.vvijayk1999.iot_alert_engine.contoller;

import io.github.vvijayk1999.iot_alert_engine.model.Device;
import io.github.vvijayk1999.iot_alert_engine.model.Telemetry;
import io.github.vvijayk1999.iot_alert_engine.repository.DeviceRepository;
import io.github.vvijayk1999.iot_alert_engine.repository.TelemetryRepository;
import io.github.vvijayk1999.iot_alert_engine.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/telemetry")
@RequiredArgsConstructor
public class TelemetryController {

    private final TelemetryRepository telemetryRepo;
    private final DeviceRepository deviceRepo;
    private final AlertService alertService;

    @PostMapping
    public ResponseEntity<?> receive(@RequestBody Telemetry telemetry) {
        telemetryRepo.save(telemetry);

        Device device = deviceRepo.findById(telemetry.getDeviceId())
                .orElseThrow(() -> new RuntimeException("Device not found"));

        telemetry.getData().forEach((param, value) -> {
            Double threshold = device.getThresholds().get(param);
            if (threshold != null && value > threshold) {
                alertService.trigger(device.getId(), param, value, threshold);
            }
        });

        return ResponseEntity.ok("Telemetry received");
    }
}

