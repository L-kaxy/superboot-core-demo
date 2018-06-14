/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.tianxin.superboot.demo.entity.po;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

import com.wteam.superboot.core.entity.po.BasePersistentObject;

/**
 * 学生持久层类.
 * 
 * @authod 罗佳欣
 */
@Entity
@Table(name = "t_student")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
public class StudentPo extends BasePersistentObject {

	/**
	 * 学生编号.
	 */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long studentid;

	/**
	 * 学生名字.
	 */
	@Column(nullable = false)
	private String studentname;

	/**
	 * 学生年龄.
	 */
	@Column(nullable = false)
	private Integer age;

	/**
	 * @return the studentid
	 */
	public Long getStudentid() {
		return studentid;
	}

	/**
	 * @param studentid
	 *            the studentid to set
	 */
	public void setStudentid(Long studentid) {
		this.studentid = studentid;
	}

	/**
	 * @return the studentname
	 */
	public String getStudentname() {
		return studentname;
	}

	/**
	 * @param studentname
	 *            the studentname to set
	 */
	public void setStudentname(String studentname) {
		this.studentname = studentname;
	}

	/**
	 * @return the age
	 */
	public Integer getAge() {
		return age;
	}

	/**
	 * @param age
	 *            the age to set
	 */
	public void setAge(Integer age) {
		this.age = age;
	}

}
