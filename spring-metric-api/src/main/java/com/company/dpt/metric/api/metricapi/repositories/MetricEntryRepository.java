package com.company.dpt.metric.api.metricapi.repositories;

import com.company.dpt.metric.api.metricapi.models.core.MetricEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface MetricEntryRepository extends JpaRepository<MetricEntry, Long> {
    @Query("SELECT max(ME.value) FROM MetricEntry ME WHERE ME.metric.id=:metricId")
    Double findMax(@Param("metricId") long metricId);

    @Query("SELECT min(ME.value) FROM MetricEntry ME WHERE ME.metric.id=:metricId")
    Double findMin(@Param("metricId") long metricId);

    @Query("SELECT avg(ME.value) FROM MetricEntry ME WHERE ME.metric.id=:metricId")
    Double findAverage(@Param("metricId") long metricId);
}
