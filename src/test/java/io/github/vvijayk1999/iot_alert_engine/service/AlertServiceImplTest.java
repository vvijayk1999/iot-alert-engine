package io.github.vvijayk1999.iot_alert_engine.service;

import io.github.vvijayk1999.iot_alert_engine.model.Alert;
import io.github.vvijayk1999.iot_alert_engine.repository.AlertRepository;
import io.github.vvijayk1999.iot_alert_engine.service.impl.AlertServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class AlertServiceImplTest {

    @Mock
    private AlertRepository repo;

    @InjectMocks
    private AlertServiceImpl service;

    @Test
    public void testTriggerAlert() {
        service.trigger("TEMP1234", "temperature", 80.0, 60.0);
        verify(repo, times(1)).save(any(Alert.class));
    }
}
