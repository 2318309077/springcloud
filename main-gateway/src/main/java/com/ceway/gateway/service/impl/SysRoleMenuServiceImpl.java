package com.ceway.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceway.gateway.mapper.SysRoleMenuMapper;
import com.ceway.gateway.bo.SysRoleMenuEntity;
import com.ceway.gateway.service.SysRoleMenuService;
import org.springframework.stereotype.Service;
/**
 * @author 伍金亮
 * @version 角色与权限业务实现
 * @date 2020/4/11 8:32 下午
 */
@Service("sysRoleMenuService")
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenuEntity> implements SysRoleMenuService {

}
