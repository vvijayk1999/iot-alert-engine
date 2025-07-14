package io.github.vvijayk1999.iot_alert_engine.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document(collection = "telemetry")
@Data
public class Telemetry {
    @Id
    private String id;
    private String deviceId;
    private Map<String, Double> data;
    private Instant timestamp = Instant.now();
}
