package com.ceway.gateway.service;
import com.baomidou.mybatisplus.extension.service.IService;
import com.ceway.gateway.bo.SysMenuEntity;
import com.ceway.gateway.bo.SysRoleEntity;
import com.ceway.gateway.bo.SysUserEntity;
import java.util.List;


/**
 * @author 伍金亮
 * @version 系统用户业务接口
 * @date 2020/4/11 8:16 下午
 */
public interface SysUserService extends IService<SysUserEntity>{

        /**
         * 根据用户名查询实体
         * @Author Sans
         * @CreateTime 2019/9/14 16:30
         * @Param  username 用户名
         * @Return SysUserEntity 用户实体
         */
        SysUserEntity selectUserByName(String username);

        /**
         * 根据用户ID查询角色集合
         * @Author Sans
         * @CreateTime 2019/9/18 18:01
         * @Param  userId 用户ID
         * @Return List<SysRoleEntity> 角色名集合
         */
        List<SysRoleEntity> selectSysRoleByUserId(Long userId);

        /**
         * 根据用户ID查询权限集合
         * @Author Sans
         * @Author Sans
         * @CreateTime 2019/9/18 18:01
         * @Param  userId 用户ID
         * @Return List<SysMenuEntity> 角色名集合
         */
        List<SysMenuEntity> selectSysMenuByUserId(Long userId);
}
