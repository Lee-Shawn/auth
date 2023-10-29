package com.laughing.system.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.laughing.model.system.SysUser;
import com.laughing.model.vo.SysUserQueryVo;

/**
* @author zane
* @description 针对表【sys_user(用户表)】的数据库操作Service
* @createDate 2023-10-21 22:22:04
*/
public interface SysUserService extends IService<SysUser> {

    /**
     * 条件分页查询
     * @param userPage 分页对象
     * @param sysUserQueryVo 查询条件
     * @return 分页对象
     */
    IPage<SysUser> selectPage(Page<SysUser> userPage, SysUserQueryVo sysUserQueryVo);

    /**
     * 更新用户状态
     * @param id 用户ID
     * @param status 用户状态
     * @return 是否更新成功
     */
    boolean updateStatus(Long id, Integer status);
}
