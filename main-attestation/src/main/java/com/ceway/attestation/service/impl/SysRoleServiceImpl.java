package com.ceway.attestation.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceway.attestation.mapper.SysRoleMapper;
import com.ceway.attestation.bo.SysRoleEntity;
import com.ceway.attestation.service.SysRoleService;
import org.springframework.stereotype.Service;
/**
 * @author 角色业务实现
 * @version 1.0
 * @date 2020/4/11 8:47 下午
 */
@Service("sysRoleService")
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRoleEntity> implements SysRoleService {

}
