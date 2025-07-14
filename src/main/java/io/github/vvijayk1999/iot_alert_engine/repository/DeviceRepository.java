package io.github.vvijayk1999.iot_alert_engine.repository;

import io.github.vvijayk1999.iot_alert_engine.model.Device;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface DeviceRepository extends MongoRepository<Device, String> {
}
