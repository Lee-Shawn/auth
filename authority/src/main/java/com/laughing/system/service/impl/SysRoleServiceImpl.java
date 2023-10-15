package com.laughing.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laughing.system.mapper.SysRoleMapper;
import com.laughing.system.service.SysRoleService;
import com.laughing.model.system.SysRole;
import com.laughing.model.vo.SysRoleQueryVo;
import org.springframework.stereotype.Service;

/**
 * @Author: laughing
 * @Create: 2023/10/14 21:36
 * @Description:
 * @Version: 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> rolePage, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectByPage(rolePage, sysRoleQueryVo);
    }
}
