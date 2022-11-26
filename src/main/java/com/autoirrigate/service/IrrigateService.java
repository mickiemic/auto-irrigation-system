package com.autoirrigate.service;

import com.autoirrigate.entity.Plot;
import lombok.extern.slf4j.Slf4j;
import org.springframework.retry.annotation.Recover;
import org.springframework.retry.annotation.Retryable;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class IrrigateService {

    public void irrigate() {
        log.info("*** irrigating ****");
    }

    @Retryable(value = Exception.class)
    public void detectSensor(Plot plot) throws Exception {
    }

    @Recover
    public void sendAlert(Exception ex, Plot plot) {
        log.warn("** Sending alert after failing to reach sensor for 15 sec **");
    }
}
