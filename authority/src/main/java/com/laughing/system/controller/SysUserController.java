package com.laughing.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laughing.common.result.Result;
import com.laughing.model.system.SysUser;
import com.laughing.model.vo.SysUserQueryVo;
import com.laughing.system.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: laughing
 * @Create: 2023/10/21 22:27
 * @Description: 用户管理接口
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/system/sysUser")
public class SysUserController {
    @Autowired
    private SysUserService sysUserService;

    /**
     * 分页查询用户
     * @param current 当前页
     * @param size 每页大小
     * @param sysUserQueryVo 查询条件
     * @return 分页对象
     */
    @GetMapping("/{current}/{size}")
    public Result<IPage<SysUser>> findPageQueryUser(@PathVariable Long current,
                                                    @PathVariable Long size,
                                                    SysUserQueryVo sysUserQueryVo) {
        Page<SysUser> userPage = new Page<>(current, size);
        IPage<SysUser> queryUser = sysUserService.selectPage(userPage, sysUserQueryVo);
        return Result.success(queryUser);
    }

    /**
     * 根据ID查询用户
     * @param id 用户ID
     * @return 用户
     */
    @GetMapping("/find/{id}")
    public Result<SysUser> findById(@PathVariable Long id) {
        SysUser sysUser = sysUserService.getById(id);
        return Result.success(sysUser);
    }

    /**
     * 添加用户
     * @param sysUser 用户
     * @return 是否添加成功
     */
    @PostMapping("/save")
    public Result<Boolean> saveUser(@RequestBody SysUser sysUser) {
        boolean save = sysUserService.save(sysUser);
        if (save) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 更新用户
     * @param sysUser 用户
     * @return 是否更新成功
     */
    @PostMapping("/update")
    public Result<Boolean> updateUser(@RequestBody SysUser sysUser) {
        boolean update = sysUserService.updateById(sysUser);
        if (update) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 删除用户
     * @param id 用户ID
     * @return 是否删除成功
     */
    @DeleteMapping("/delete/{id}")
    public Result<Boolean> deleteUser(@PathVariable Long id) {
        boolean deleted = sysUserService.removeById(id);
        if (deleted) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 批量删除用户
     * @param ids 删除的用户ID集合
     * @return 是否删除成功
     */
    @DeleteMapping("/remove")
    public Result<Boolean> deleteUsers(@RequestBody List<Long> ids) {
        boolean deleted = sysUserService.removeByIds(ids);
        if (deleted) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 更新用户状态
     * @param id 用户ID
     * @param status 用户状态
     * @return 是否更新成功
     */
    @PutMapping("/updateStatus/{id}/{status}")
    public Result<Boolean> updateStatus(@PathVariable Long id, @PathVariable Integer status) {
        boolean updateStatus = sysUserService.updateStatus(id, status);
        if (updateStatus) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
}
