package com.ceway.gateway.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ceway.gateway.bo.SysMenuEntity;
import com.ceway.gateway.bo.SysRoleEntity;
import com.ceway.gateway.bo.SysUserEntity;
import org.apache.ibatis.annotations.Mapper;
import java.util.List;
/**
 * @author 伍金亮
 * @version 系统用户
 * @date 2020/4/11 9:45 下午
 */
@Mapper
public interface SysUserMapper extends BaseMapper<SysUserEntity> {

    /**
     * 通过用户ID查询角色集合
     * @Author Sans
     * @CreateTime 2019/9/18 18:01
     * @Param  userId 用户ID
     * @Return List<SysRoleEntity> 角色名集合
     */
    List<SysRoleEntity> selectSysRoleByUserId(Long userId);
    /**
     * 通过用户ID查询权限集合
     * @Author Sans
     * @CreateTime 2019/9/18 18:01
     * @Param  userId 用户ID
     * @Return List<SysMenuEntity> 角色名集合
     */
    List<SysMenuEntity> selectSysMenuByUserId(Long userId);

}
