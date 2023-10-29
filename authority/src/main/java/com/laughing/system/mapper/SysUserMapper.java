package com.laughing.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laughing.model.system.SysUser;
import com.laughing.model.vo.SysUserQueryVo;
import org.apache.ibatis.annotations.Param;

/**
* @author zane
* @description 针对表【sys_user(用户表)】的数据库操作Mapper
* @createDate 2023-10-21 22:22:04
* @Entity com.laughing.model.system.SysUser
*/
public interface SysUserMapper extends BaseMapper<SysUser> {
    /**
     * 条件分页查询
     * @param userPage 分页对象
     * @param sysUserQueryVo 查询条件
     * @return 分页对象
     */
    IPage<SysUser> selectByPage(Page<SysUser> userPage, @Param("vo") SysUserQueryVo sysUserQueryVo);
}




