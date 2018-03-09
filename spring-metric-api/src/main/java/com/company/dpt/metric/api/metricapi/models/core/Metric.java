package com.company.dpt.metric.api.metricapi.models.core;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Metric {
    @Id
    @Column(name = "MET_ID")
    private long id;

    @NotNull
    @Size(min = 2, max = 20)
    @Column(name = "MED_NAME")
    private String name;

    @OneToMany(mappedBy = "metric")
    private List<MetricEntry> metricEntries = new ArrayList<>();

    public Metric() {
    }

    public long getId() {
        return this.id;
    }

    public @NotNull @Size(min = 2, max = 20) String getName() {
        return this.name;
    }

    public List<MetricEntry> getMetricEntries() {
        return this.metricEntries;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setName(@NotNull @Size(min = 2, max = 20) String name) {
        this.name = name;
    }

    public void setMetricEntries(List<MetricEntry> metricEntries) {
        this.metricEntries = metricEntries;
    }

    public void setMetricEntry(MetricEntry metricEntry) {
        this.metricEntries.add(metricEntry);
    }

    public String toString() {
        return "Metric(id=" + this.getId() + ", name=" + this.getName() + ", metricEntries=" + this.getMetricEntries() + ")";
    }
}
