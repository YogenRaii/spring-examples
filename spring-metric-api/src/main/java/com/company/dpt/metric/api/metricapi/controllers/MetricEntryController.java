package com.company.dpt.metric.api.metricapi.controllers;

import com.company.dpt.metric.api.metricapi.exceptions.DataException;
import com.company.dpt.metric.api.metricapi.models.common.ErrorCodes;
import com.company.dpt.metric.api.metricapi.models.core.Metric;
import com.company.dpt.metric.api.metricapi.models.core.MetricEntry;
import com.company.dpt.metric.api.metricapi.models.interfaces.MetricEntryRequest;
import com.company.dpt.metric.api.metricapi.models.interfaces.MetricRequest;
import com.company.dpt.metric.api.metricapi.services.MetricEntryService;
import com.company.dpt.metric.api.metricapi.services.MetricService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RequestMapping("/api/metrics")
@RestController
public class MetricEntryController {
    @Autowired
    private MetricEntryService metricEntryService;

    @PostMapping(value = "/entries", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<MetricEntry> createMetric(@Valid @RequestBody MetricEntryRequest metric, BindingResult result) {
        if (result.hasErrors()) {
            throw new DataException(ErrorCodes.EXC400.toString(), result);
        }

        MetricEntry metricCreated = metricEntryService.createMetricEntry(metric);

        return new ResponseEntity<>(metricCreated, HttpStatus.CREATED);
    }
}
