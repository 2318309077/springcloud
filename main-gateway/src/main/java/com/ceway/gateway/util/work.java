package com.ceway.gateway.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import com.ceway.gateway.util.JwtHelper;
import com.nimbusds.jose.JOSEException;

public class work {
	//生成token的业务逻辑
    public static String TokenTest(String uid) {
        //获取生成token

        Map<String, Object> map = new HashMap<>();

        //建立载荷，这些数据根据业务，自己定义。
        map.put("uid", uid);
        //生成时间
        map.put("sta", new Date().getTime());
        //过期时间
        map.put("exp", new Date().getTime()+6000);
        try {
            String token = JwtHelper.creatToken(map);
            System.out.println("token="+token);
            return token;
        } catch (JOSEException e) {
            System.out.println("生成token失败");
            e.printStackTrace();
        }
        return null;

    }

    //处理解析的业务逻辑
    public static void ValidToken(String token) {
        //解析token
        try {
            if (token != null) {

                Map<String, Object> validMap = JwtHelper.valid(token);
                int i = (int) validMap.get("Result");
                if (i == 0) {
                    System.out.println("token解析成功");
//                    JSONObject jsonObject = (JSONObject) validMap.get("data");
//                    System.out.println("uid是" + jsonObject.get("uid"));
//                    System.out.println("sta是"+jsonObject.get("sta"));
//                    System.out.println("exp是"+jsonObject.get("exp"));
                    System.out.println("json字符:"+validMap.get("data"));
                } else if (i == 2) {
                    System.out.println("token已经过期");
                }
            }
        }catch (JOSEException e) {
            System.out.println("生成token失败");
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } 
    }
    
    public void main() {
        //获取token
        String uid = "kkksuejrmf";
        String token = TokenTest(uid);
        //解析token
        ValidToken(token);
    }
}
