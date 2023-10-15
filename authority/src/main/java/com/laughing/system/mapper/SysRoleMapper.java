package com.laughing.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laughing.model.system.SysRole;
import com.laughing.model.vo.SysRoleQueryVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @Author: laughing
 * @Create: 2023/10/14 20:24
 * @Description:
 * @Version: 1.0
 */
@Repository
public interface SysRoleMapper extends BaseMapper<SysRole> {
    /**
     * 条件分页查询
     * @param rolePage 分页对象
     * @param sysRoleQueryVo 查询条件
     * @return 分页对象
     */
    IPage<SysRole> selectByPage(Page<SysRole> rolePage, @Param("vo") SysRoleQueryVo sysRoleQueryVo);
}
