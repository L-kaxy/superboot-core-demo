/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.tianxin.superboot.demo.controller.param;

import com.tianxin.superboot.demo.entity.po.StudentPo;

/**
 * 学生模块请求参数.
 * 
 * @authod 罗佳欣
 */
public class StudentParam {

	private StudentPo student;

	public StudentPo getStudent() {
		return student;
	}

	public void setStudent(StudentPo student) {
		this.student = student;
	}

}
