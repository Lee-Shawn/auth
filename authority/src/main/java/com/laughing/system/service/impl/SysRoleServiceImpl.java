package com.laughing.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.laughing.model.system.SysUserRole;
import com.laughing.model.vo.AssginRoleVo;
import com.laughing.system.mapper.SysRoleMapper;
import com.laughing.system.mapper.SysUserRoleMapper;
import com.laughing.system.service.SysRoleService;
import com.laughing.model.system.SysRole;
import com.laughing.model.vo.SysRoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: laughing
 * @Create: 2023/10/14 21:36
 * @Description:
 * @Version: 1.0
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<SysRoleMapper, SysRole> implements SysRoleService {
    @Autowired
    private SysUserRoleMapper sysUserRoleMapper;

    /**
     * 条件分页查询
     * @param rolePage 分页对象
     * @param sysRoleQueryVo 查询条件
     * @return 分页对象
     */
    @Override
    public IPage<SysRole> selectPage(Page<SysRole> rolePage, SysRoleQueryVo sysRoleQueryVo) {
        return baseMapper.selectByPage(rolePage, sysRoleQueryVo);
    }

    /**
     * 根据用户ID查询用户所拥有的角色
     * @param userId 用户ID
     * @return 角色
     */
    @Override
    public Map<String, Object> getRolesByUserId(Long userId) {
        // 获取所有角色
        List<SysRole> sysRoles = baseMapper.selectList(null);
        // 根据用户ID查询
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", userId);
        // 获取用户已分配的角色
        List<SysUserRole> sysUserRoles = sysUserRoleMapper.selectList(queryWrapper);
        // 获取用户已分配的角色id
        List<String> userRoleIds = new ArrayList<>();
        for (SysUserRole sysUserRole : sysUserRoles) {
            userRoleIds.add(sysUserRole.getRoleId());
        }
        // 封装角色到Map中
        Map<String, Object> map = new HashMap<>();
        map.put("roles", sysRoles);
        map.put("userRoleIds", userRoleIds);
        return map;
    }

    /**
     * 根据用户分配角色
     * @param assginRoleVo 分配角色
     */
    @Override
    public void doAssign(AssginRoleVo assginRoleVo) {
        // 根据用户id删除原来分配的角色
        QueryWrapper<SysUserRole> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("user_id", assginRoleVo.getUserId());
        sysUserRoleMapper.delete(queryWrapper);
        // 添加新的分配的角色
        List<String> roleIdList = assginRoleVo.getRoleIdList();
        for (String roleId : roleIdList) {
            SysUserRole sysUserRole = new SysUserRole();
            sysUserRole.setUserId(assginRoleVo.getUserId());
            sysUserRole.setRoleId(roleId);
            sysUserRoleMapper.insert(sysUserRole);
        }
    }
}
