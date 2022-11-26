package com.autoirrigate.schedule;

import com.autoirrigate.service.IrrigateService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class ScheduledIrrigation {

    private IrrigateService irrigateService;

    public ScheduledIrrigation(IrrigateService irrigateService) {
        this.irrigateService = irrigateService;
    }

    @Scheduled(fixedRate = 15000)
    public void startIrrigation() {
        log.info(">> triggering irrigation task...");
        irrigateService.irrigate();
    }

}
