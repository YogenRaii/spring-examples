package com.company.dpt.metric.api.metricapi.services;

import com.company.dpt.metric.api.metricapi.models.core.Metric;
import com.company.dpt.metric.api.metricapi.models.core.MetricEntry;
import com.company.dpt.metric.api.metricapi.models.interfaces.MetricEntryRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface MetricEntryService {
    MetricEntry createMetricEntry(MetricEntryRequest metric);
}
