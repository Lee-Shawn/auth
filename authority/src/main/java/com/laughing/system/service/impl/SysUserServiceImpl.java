package com.laughing.system.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laughing.model.system.SysUser;
import com.laughing.model.vo.SysUserQueryVo;
import com.laughing.system.service.SysUserService;
import com.laughing.system.mapper.SysUserMapper;
import org.springframework.stereotype.Service;

/**
* @author zane
* @description 针对表【sys_user(用户表)】的数据库操作Service实现
* @createDate 2023-10-21 22:22:04
*/
@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {

    /**
     * 条件分页查询
     * @param userPage 分页对象
     * @param sysUserQueryVo 查询条件
     * @return 分页对象
     */
    @Override
    public IPage<SysUser> selectPage(Page<SysUser> userPage, SysUserQueryVo sysUserQueryVo) {
        return baseMapper.selectByPage(userPage, sysUserQueryVo);
    }

    /**
     * 更新用户状态
     * @param id 用户ID
     * @param status 用户状态
     * @return 是否更新成功
     */
    @Override
    public boolean updateStatus(Long id, Integer status) {
        SysUser sysUser = baseMapper.selectById(id);
        sysUser.setStatus(status);
        int result = baseMapper.updateById(sysUser);
        return result > 0;
    }
}




