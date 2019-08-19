package com.ceway.EsAndCanel.es;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.ceway.EsAndCanel.vo.MonitorAlarmVO;

public interface MonitorAlarmRepository extends ElasticsearchRepository<MonitorAlarmVO, Long>{

}
