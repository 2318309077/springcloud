package com.ceway.attestation.common.util;

import com.ceway.attestation.security.entity.SelfUserEntity;
import org.springframework.security.core.context.SecurityContextHolder;
/**
 * @author 伍金亮
 * @version Security工具类
 * @date 2020/4/11 11:04 下午
 */
public class SecurityUtil {
    /**
     * 私有化构造器
     */
    private SecurityUtil(){}

    /**
     * 获取当前用户信息
     */
    public static SelfUserEntity getUserInfo(){
        SelfUserEntity userDetails = (SelfUserEntity) SecurityContextHolder.getContext().getAuthentication() .getPrincipal();
        return userDetails;
    }
    /**
     * 获取当前用户ID
     */
    public static Long getUserId(){
        return getUserInfo().getUserId();
    }
    /**
     * 获取当前用户账号
     */
    public static String getUserName(){
        return getUserInfo().getUsername();
    }
}
