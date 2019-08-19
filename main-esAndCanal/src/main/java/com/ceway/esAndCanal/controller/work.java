package com.ceway.esAndCanal.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/add/")
public class work {
	   
	      @RequestMapping("/sj")
       public String sd(){
    	  System.out.println("===================="+System.currentTimeMillis());
    	   return "伍金良的路由!";
       }
}
