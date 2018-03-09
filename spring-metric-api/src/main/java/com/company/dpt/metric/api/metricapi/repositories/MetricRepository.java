package com.company.dpt.metric.api.metricapi.repositories;

import com.company.dpt.metric.api.metricapi.models.core.Metric;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MetricRepository extends JpaRepository<Metric, Long> {
    Metric findByName(String name);
}
