package com.company.dpt.metric.api.metricapi.services;

import com.company.dpt.metric.api.metricapi.models.core.Metric;
import com.company.dpt.metric.api.metricapi.models.interfaces.MetricEntryRequest;
import com.company.dpt.metric.api.metricapi.models.interfaces.Statistics;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MetricService {
    Metric createMetric(Metric metric);

    Page<Metric> getMetricNames(Pageable pageable);

    Statistics getSummaryStatistics(long metricId, List<String> statisticNames);
}
