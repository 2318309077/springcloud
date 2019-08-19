package com.ceway.EsAndCanel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceway.EsAndCanel.es.MonitorAlarmRepository;
import com.ceway.EsAndCanel.vo.MonitorAlarmVO;



@RestController
@RequestMapping("/add/")
public class work {
	   
		@Autowired
		private MonitorAlarmRepository monitorAlarmRepository;
	   
       @RequestMapping("/sj")
//     @RepeatRequest(value="add")
       public String wu(String ja){
    	   MonitorAlarmVO vo = new MonitorAlarmVO();
    	   vo.setId(1);
    	   vo.setName("伍金亮");
    	   vo.setUname("伍金亮会实现一年赚一个亿!");
    	   monitorAlarmRepository.save(vo);
    	   return ja;
       }
}
