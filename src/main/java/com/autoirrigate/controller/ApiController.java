package com.autoirrigate.controller;

import com.autoirrigate.entity.Plot;
import com.autoirrigate.model.apimodels.StringResponse;
import com.autoirrigate.service.PlotService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.attribute.standard.Media;
import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1")
public class ApiController {

    private PlotService plotService;

    public ApiController(PlotService plotService) {
        this.plotService = plotService;
    }

    @GetMapping(value = "/getplots", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPlots() {
        try {
            return ResponseEntity.ok().body(plotService.getPlots());
        } catch (Exception ex) {
            log.error("/getPlots {}", ex.getMessage());
            return ResponseEntity.status(500).body(new StringResponse(ex.getMessage()));
        }
    }
    @GetMapping(value = "/getplot/{plotId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity getPlotById(@PathVariable("plotId") long plotId) {
        Plot plot;
        try {
            plot = plotService.getPlot(plotId);
            if (plot == null)
                return ResponseEntity.status(404).body(new StringResponse("Plot not found"));
            return ResponseEntity.ok().body(plot);
        } catch (Exception ex) {
            log.error("/getPlotById {}", ex.getMessage());
            return ResponseEntity.status(500).body(new StringResponse(ex.getMessage()));
        }
    }

    @PostMapping(value = "/addplot", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<StringResponse> addPlot(@RequestBody Plot plot) {
        return plotService.addPlot(plot);
    }

    @PutMapping(value = "/configureplaot", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity configurePlot(@RequestBody Plot plot) {
        return null;
    }

}
