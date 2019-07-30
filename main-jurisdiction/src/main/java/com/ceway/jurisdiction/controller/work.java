package com.ceway.jurisdiction.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceway.jurisdiction.mq.CallBackSender;


@RestController
@RequestMapping("/add/")
public class work {
	   
		@Autowired
		private CallBackSender sender;
	   
       @RequestMapping("/sj")
//       @RepeatRequest(value="add")
       public String wu(String ja){
    	     sender.send("topic.baqgl.admin.one", ja);   
    	   return ja;
       }
}
