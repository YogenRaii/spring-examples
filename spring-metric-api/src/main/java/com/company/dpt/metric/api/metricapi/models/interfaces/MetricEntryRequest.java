package com.company.dpt.metric.api.metricapi.models.interfaces;

import lombok.Data;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
public class MetricEntryRequest {
    @Min(0)
    private long metricId;

    private double value;
}
