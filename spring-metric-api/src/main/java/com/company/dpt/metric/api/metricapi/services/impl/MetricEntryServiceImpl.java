package com.company.dpt.metric.api.metricapi.services.impl;

import com.company.dpt.metric.api.metricapi.exceptions.AlreadyExistsException;
import com.company.dpt.metric.api.metricapi.exceptions.NotFoundException;
import com.company.dpt.metric.api.metricapi.models.common.ErrorCodes;
import com.company.dpt.metric.api.metricapi.models.core.Metric;
import com.company.dpt.metric.api.metricapi.models.core.MetricEntry;
import com.company.dpt.metric.api.metricapi.models.interfaces.MetricEntryRequest;
import com.company.dpt.metric.api.metricapi.repositories.MetricEntryRepository;
import com.company.dpt.metric.api.metricapi.repositories.MetricRepository;
import com.company.dpt.metric.api.metricapi.services.MetricEntryService;
import com.company.dpt.metric.api.metricapi.services.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MetricEntryServiceImpl implements MetricEntryService {
    @Autowired
    private MetricEntryRepository metricEntryRepository;

    @Autowired
    private MetricRepository metricRepository;

    @Override
    public MetricEntry createMetricEntry(MetricEntryRequest metricReq) {
        Optional<Metric> metricOptional = this.metricRepository.findById(metricReq.getMetricId());
        if (!metricOptional.isPresent()) {
            throw new NotFoundException(ErrorCodes.EXC404.getValue(), null);
        }
        Metric metric = metricOptional.get();

        MetricEntry entry = new MetricEntry();
        entry.setValue(metricReq.getValue());
        entry.setMetric(metricOptional.get());

        metric.setMetricEntry(entry);
        this.metricRepository.save(metric);

        return entry;
    }
}
