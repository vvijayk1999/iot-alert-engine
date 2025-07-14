package io.github.vvijayk1999.iot_alert_engine.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;
import java.util.Map;

@Document(collection = "devices")
@Data
public class Device {
    @Id
    private String id;
    private String name;
    private Map<String, Double> thresholds;
    private Instant createdAt = Instant.now();
}