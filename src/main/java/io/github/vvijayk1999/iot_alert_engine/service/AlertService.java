package io.github.vvijayk1999.iot_alert_engine.service;

import io.github.vvijayk1999.iot_alert_engine.model.Alert;

import java.util.List;

public interface AlertService {
    void trigger(String deviceId, String parameter, double actual, double threshold);
    List<Alert> getAll();
}