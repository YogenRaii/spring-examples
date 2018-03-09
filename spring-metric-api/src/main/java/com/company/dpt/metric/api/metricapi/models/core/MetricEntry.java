package com.company.dpt.metric.api.metricapi.models.core;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
public class MetricEntry {
    @Id
    @Column(name = "ENT_ID")
    private long id;

    @Column(name = "ENT_VALUE")
    private double value;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "MET_ID")
    private Metric metric;
}
