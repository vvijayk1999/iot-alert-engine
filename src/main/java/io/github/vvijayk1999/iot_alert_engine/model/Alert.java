package io.github.vvijayk1999.iot_alert_engine.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.Instant;

@Document(collection = "alerts")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Alert {
    @Id
    private String id;
    private String deviceId;
    private String parameter;
    private double actualValue;
    private double threshold;
    private Instant timestamp = Instant.now();
}

