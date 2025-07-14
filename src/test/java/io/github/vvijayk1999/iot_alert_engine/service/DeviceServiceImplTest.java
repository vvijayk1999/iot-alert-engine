package io.github.vvijayk1999.iot_alert_engine.service;

import io.github.vvijayk1999.iot_alert_engine.model.Device;
import io.github.vvijayk1999.iot_alert_engine.repository.DeviceRepository;
import io.github.vvijayk1999.iot_alert_engine.service.impl.DeviceServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
public class DeviceServiceImplTest {

    @Mock
    private DeviceRepository deviceRepo;

    @InjectMocks
    private DeviceServiceImpl service;

    @Test
    public void testCreateDevice() {
        Device device = new Device();
        device.setName("Sensor A");

        Mockito.when(deviceRepo.save(device)).thenReturn(device);

        Device saved = service.create(device);
        assertEquals("Sensor A", saved.getName());
        verify(deviceRepo, times(1)).save(device);
    }
}

