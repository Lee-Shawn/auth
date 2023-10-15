package com.laughing.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.laughing.model.system.SysRole;
import com.laughing.model.vo.SysRoleQueryVo;

/**
 * @Author: laughing
 * @Create: 2023/10/14 21:35
 * @Description:
 * @Version: 1.0
 */
public interface SysRoleService extends IService<SysRole> {
    /**
     * 条件分页查询
     * @param rolePage 分页对象
     * @param sysRoleQueryVo 查询条件
     * @return 分页对象
     */
    IPage<SysRole> selectPage(Page<SysRole> rolePage, SysRoleQueryVo sysRoleQueryVo);
}
