package com.autoirrigate.repo;

import com.autoirrigate.entity.Plot;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlotRepo extends JpaRepository<Plot, Long> {
}
