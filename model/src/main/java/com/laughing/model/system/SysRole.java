package com.laughing.model.system;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.laughing.model.base.BaseEntity;
import lombok.Data;


@Data
@TableName("sys_role") // 表名注解，标识实体类对应的表
public class SysRole extends BaseEntity {
	
	private static final long serialVersionUID = 1L;

	// 角色名称
	@TableField("role_name") // 字段注解
	private String roleName;

	// 角色编码
	@TableField("role_code")
	private String roleCode;

	// 角色描述
	@TableField("description")
	private String description;

}

