package io.github.vvijayk1999.iot_alert_engine.repository;

import io.github.vvijayk1999.iot_alert_engine.model.Telemetry;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TelemetryRepository extends MongoRepository<Telemetry, String> {
}
