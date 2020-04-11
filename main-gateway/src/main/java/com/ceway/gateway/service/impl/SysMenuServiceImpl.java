package com.ceway.gateway.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ceway.gateway.mapper.SysMenuMapper;
import com.ceway.gateway.bo.SysMenuEntity;
import com.ceway.gateway.service.SysMenuService;
import org.springframework.stereotype.Service;
/**
 * @author 伍金亮
 * @version 权限业务实现
 * @date 2020/4/11 8:27 下午
 */
@Service("sysMenuService")
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenuEntity> implements SysMenuService {

}
