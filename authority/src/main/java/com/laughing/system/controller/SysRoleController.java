package com.laughing.system.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.laughing.system.service.SysRoleService;
import com.laughing.common.result.Result;
import com.laughing.model.system.SysRole;
import com.laughing.model.vo.SysRoleQueryVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Author: laughing
 * @Create: 2023/10/14 22:13
 * @Description: 角色Controller
 * @Version: 1.0
 */
@RestController
@RequestMapping("/admin/system/sysRole")
public class SysRoleController {
    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 逻辑查询所有角色接口
     * @return 所有角色集合
     */
    @GetMapping("findAll")
    public Result<List<SysRole>> findAll() {
        List<SysRole> sysRoleList = sysRoleService.list();
        return Result.success(sysRoleList);
    }

    /**
     * 分页查询角色
     * @param current 当前页
     * @param size 每页大小
     * @param sysRoleQueryVo 查询条件
     * @return 分页对象
     */
    @GetMapping("/{current}/{size}")
    public Result<IPage<SysRole>> findPageQueryRole(@PathVariable Long current,
                                                    @PathVariable Long size,
                                                    SysRoleQueryVo sysRoleQueryVo) {
        Page<SysRole> rolePage = new Page<>(current, size);
        IPage<SysRole> queryRole = sysRoleService.selectPage(rolePage, sysRoleQueryVo);
        return Result.success(queryRole);
    }

    /**
     * 添加角色接口
     * @param sysRole 角色对象
     * @return 是否添加成功
     */
    @PostMapping("/save")
    public Result<Boolean> saveRole(@RequestBody SysRole sysRole) {
        boolean save = sysRoleService.save(sysRole);
        if (save) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 修改角色接口
     * @param sysRole 角色对象
     * @return 是否修改成功
     */
    @PostMapping("/update")
    public Result<Boolean> updateRole(@RequestBody SysRole sysRole) {
        boolean update = sysRoleService.updateById(sysRole);
        if (update) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 逻辑删除角色
     * @param id 删除的角色ID
     * @return 是否删除成功
     */
    @DeleteMapping("delete/{id}")
    public Result<Boolean> deleteRole(@PathVariable Long id) {
        boolean deleted = sysRoleService.removeById(id);
        if (deleted) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }

    /**
     * 批量删除角色
     * @param ids 删除的角色ID集合
     * @return 是否删除成功
     */
    @DeleteMapping("/remove")
    public Result<Boolean> deleteRoles(@RequestBody List<Long> ids) {
        boolean removed = sysRoleService.removeBatchByIds(ids);
        if (removed) {
            return Result.success();
        } else {
            return Result.fail();
        }
    }
}
