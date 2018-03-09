package com.company.dpt.metric.api.metricapi.models.interfaces;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Statistics {
    private Double mean;
    private Double median;
    private Double max;
    private Double min;

    public void setMean(Double mean) {
        this.mean = mean;
    }

    public void setMedian(Double median) {
        this.median = median;
    }

    public void setMax(Double max) {
        this.max = max;
    }

    public void setMin(Double min) {
        this.min = min;
    }

    public Double getMean() {
        return mean;
    }

    public Double getMedian() {
        return median;
    }

    public Double getMax() {
        return max;
    }

    public Double getMin() {
        return min;
    }
}
