package com.ceway.jurisdiction.filter;

import com.ceway.jurisdiction.conf.RedisClient;
import com.google.common.collect.Maps;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;

import javax.servlet.http.HttpServletRequest;

import java.util.Enumeration;
import java.util.Map;

@Aspect
@Component
public class RepeatAOP {
	   
	    @Autowired
	    private RedisClient redisClient;
	    
	    @Around(value="@annotation(repeatRequest)")
	    public Object dofore(ProceedingJoinPoint  joinPoint,RepeatRequest repeatRequest){
	    	String key = "";
	    	try {
	    		Signature signature=joinPoint.getSignature(); //  用的最多，通知的签名
	        	// 进行标签过滤
	        	if(!repeatRequest.value().equals("add")){
	        		return  "您所使用的注解有问题,使用的地方为:"+signature.getDeclaringTypeName()+"-"+signature.getName();
	        	}
               /*
	                                   通过RequestContextHolder获取请求信息，如session 信息 ;
	            */
	            //  获取RequestAttributes
	            RequestAttributes requestAttributes= RequestContextHolder.getRequestAttributes();
	            //  从requestAttributes中获取HttpServletRequest信息
	            HttpServletRequest request=(HttpServletRequest)requestAttributes.resolveReference(RequestAttributes.REFERENCE_REQUEST);
	            Enumeration<String> enumerations=request.getParameterNames();
	            Map<String,String> parameterMaps= Maps.newHashMap();
	            while(enumerations.hasMoreElements()){
	                String parameter=enumerations.nextElement();
	                parameterMaps.put(parameter,request.getParameter(parameter));
	            }
	            String obj = signature.getDeclaringTypeName()+"/"+signature.getName()+"/"+parameterMaps;
	            key = Integer.toString(obj.hashCode());
                String value = Integer.toString(parameterMaps.hashCode());
                if(redisClient.exists(key)){
                	return  "重复提交数据";
                }
	            redisClient.setWithExpireTime(key, value,5);
	            
	            return  joinPoint.proceed();
	        } catch (Throwable e) {
	        	redisClient.del(key);
	        	e.printStackTrace();
	        }
		    return  "您所行的地方有错误!";
	    }
}
