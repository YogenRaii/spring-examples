package com.company.dpt.metric.api.metricapi.services.impl;

import com.company.dpt.metric.api.metricapi.exceptions.AlreadyExistsException;
import com.company.dpt.metric.api.metricapi.models.common.ErrorCodes;
import com.company.dpt.metric.api.metricapi.models.core.Metric;
import com.company.dpt.metric.api.metricapi.models.interfaces.Statistics;
import com.company.dpt.metric.api.metricapi.repositories.MetricEntryRepository;
import com.company.dpt.metric.api.metricapi.repositories.MetricRepository;
import com.company.dpt.metric.api.metricapi.services.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MetricServiceImpl implements MetricService {
    @Autowired
    private MetricRepository metricRepository;

    @Autowired
    private MetricEntryRepository metricEntryRepository;

    @Override
    public Metric createMetric(Metric metric) {
        Metric metricInDb = this.metricRepository.findByName(metric.getName());
        if (metricInDb != null) {
            throw new AlreadyExistsException(ErrorCodes.EXC409.getValue(), null);
        }
        return metricRepository.save(metric);
    }

    @Override
    public Page<Metric> getMetricNames(Pageable pageable) {
        return this.metricRepository.findAll(pageable);
    }

    @Override
    public Statistics getSummaryStatistics(long metricId, List<String> statisticNames) {
        Statistics statistics = new Statistics();

        // if names passed, return all statistics
        if (statisticNames == null) {
            statistics.setMin(metricEntryRepository.findMin(metricId));
            statistics.setMax(metricEntryRepository.findMax(metricId));
            statistics.setMean(metricEntryRepository.findAverage(metricId));
            return statistics;
        }

        // if names passed, return only those statistics
        if (statisticNames.contains("MIN")) {
            statistics.setMin(metricEntryRepository.findMin(metricId));
        }
        if (statisticNames.contains("MAX")) {
            statistics.setMax(metricEntryRepository.findMax(metricId));
        }
        if (statisticNames.contains("AVG")) {
            statistics.setMean(metricEntryRepository.findAverage(metricId));
        }

        return statistics;
    }
}
