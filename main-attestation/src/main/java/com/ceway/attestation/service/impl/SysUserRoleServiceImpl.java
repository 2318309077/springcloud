package com.ceway.attestation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceway.attestation.mapper.SysUserRoleMapper;
import com.ceway.attestation.bo.SysUserRoleEntity;
import com.ceway.attestation.service.SysUserRoleService;
import org.springframework.stereotype.Service;
/**
 * @author 伍金亮
 * @version 用户与角色业务实现
 * @date 2020/4/11 8:49 下午
 */
@Service("sysUserRoleService")
public class SysUserRoleServiceImpl extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements SysUserRoleService {

}
