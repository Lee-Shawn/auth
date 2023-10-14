package com.laughing.authority.test;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.laughing.authority.mapper.SysRoleMapper;
import com.laughing.model.system.SysRole;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

/**
 * Unit test for simple App.
 */
@SpringBootTest
public class SysRoleMapperTest {
    @Autowired
    private SysRoleMapper sysRoleMapper;

    @Test
    public void testSelectAll() {
        List<SysRole> sysRoles = sysRoleMapper.selectList(null);
        for (SysRole sysRole : sysRoles) {
            System.out.println(sysRole);
        }
    }

    @Test
    public void testInsert() {
        SysRole role = new SysRole();
        role.setRoleName("测试角色");
        role.setDescription("测试");
        int result = sysRoleMapper.insert(role);
        System.out.println(result);
    }

    @Test
    public void testUpdate() {
        SysRole role = sysRoleMapper.selectById(9);
        role.setRoleCode("test");
        sysRoleMapper.updateById(role);
    }

    @Test
    public void testDelete() {
        sysRoleMapper.deleteById(9);
    }

    @Test
    public void testBatchDelete() {
        sysRoleMapper.deleteBatchIds(Arrays.asList(8, 9));
    }

    @Test
    public void testWrapper() {
        QueryWrapper<SysRole> wrapper = new QueryWrapper<>();
        wrapper.like("role_code", "test");
        sysRoleMapper.selectList(wrapper);
    }
}
