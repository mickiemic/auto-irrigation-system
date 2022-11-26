package com.autoirrigate.service;

import com.autoirrigate.entity.Plot;
import com.autoirrigate.model.apimodels.StringResponse;
import com.autoirrigate.repo.PlotRepo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@Service
public class PlotService {

    private PlotRepo plotRepo;

    public PlotService(PlotRepo plotRepo) {
        this.plotRepo = plotRepo;
    }

    public List<Plot> getPlots() {
        try {
            return plotRepo.findAll();
        } catch (Exception ex) {
            log.error("PlotService getPlots {}", ex.getMessage());
            throw ex;
        }
    }
    public Plot getPlot(Long plotId) {
        try {
            Optional<Plot> plotOptional = plotRepo.findById(plotId);
            if (!plotOptional.isPresent())
                return null;
            return plotOptional.get();
        } catch (Exception ex) {
            log.error("PlotService getPlot {}", ex.getMessage());
            throw ex;
        }
    }

    public ResponseEntity<StringResponse> addPlot(Plot plot) {
        String strResp = "";
        try {
            plot = plotRepo.save(plot);
            strResp = "Plot created with ID " + plot.getId();
            return ResponseEntity.ok(new StringResponse(strResp));
        } catch (Exception ex) {
            log.error("PlotService addPlot {}", ex.getMessage());
            strResp = ex.getMessage();
            return ResponseEntity.status(500).body(new StringResponse(strResp));
        }
    }

}
