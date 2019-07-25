package com.ceway.jurisdiction.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ceway.jurisdiction.filter.RepeatRequest;


@RestController
@RequestMapping("/add/")
public class work {
	  
	   
       @RequestMapping("/sj")
       @RepeatRequest(value="add")
       public String wu(String ja){
    	   System.out.println("===================="+System.currentTimeMillis());
    	   return ja;
       }
}
