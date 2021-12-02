package com.noffabel.iot.dao;

import com.noffabel.iot.dao.entity.HeatMapData;
import com.noffabel.iot.dao.entity.TotalTrafficData;

import org.springframework.data.cassandra.repository.CassandraRepository;
import org.springframework.data.cassandra.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.UUID;

/**
 * DAO class for total_traffic
 *
 * @author noffabel
 */
@Repository
public interface HeatMapDataRepository extends CassandraRepository<HeatMapData, UUID> {

    @Query("SELECT * FROM traffickeyspace.heat_map WHERE timestamp = ?0 ALLOW FILTERING")
    Iterable<TotalTrafficData> findHeatMapByDate(Date date);
}
