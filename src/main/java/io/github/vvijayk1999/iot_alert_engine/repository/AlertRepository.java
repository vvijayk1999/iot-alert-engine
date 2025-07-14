package io.github.vvijayk1999.iot_alert_engine.repository;

import io.github.vvijayk1999.iot_alert_engine.model.Alert;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface AlertRepository extends MongoRepository<Alert, String> {
}
