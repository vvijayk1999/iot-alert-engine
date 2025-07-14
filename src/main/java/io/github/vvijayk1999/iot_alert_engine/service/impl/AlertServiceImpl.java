package io.github.vvijayk1999.iot_alert_engine.service.impl;

import io.github.vvijayk1999.iot_alert_engine.model.Alert;
import io.github.vvijayk1999.iot_alert_engine.repository.AlertRepository;
import io.github.vvijayk1999.iot_alert_engine.service.AlertService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AlertServiceImpl implements AlertService {

    private final AlertRepository alertRepo;
    private static final Logger log = LoggerFactory.getLogger(AlertServiceImpl.class);

    @Override
    public void trigger(String deviceId, String parameter, double actual, double threshold) {
        alertRepo.save(new Alert(null, deviceId, parameter, actual, threshold, Instant.now()));
        // TODO: SNS/Email log here

        log.warn("ALERT: {} exceeded threshold! value={}, threshold={}",
                parameter, actual, threshold);
    }

    @Override
    public List<Alert> getAll() {
        return alertRepo.findAll();
    }
}

