/**
 * Copyright (c) 2007-2017 Wteam.  All rights reserved. 网维网络技术创业团队 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.tianxin.superboot.demo.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tianxin.superboot.demo.entity.po.StudentPo;
import com.tianxin.superboot.demo.repository.StudentRepository;
import com.wteam.superboot.core.entity.po.UserPo;
import com.wteam.superboot.core.enums.ResultEnum;
import com.wteam.superboot.core.exception.SuperException;
import com.wteam.superboot.core.helper.ResultHelper;
import com.wteam.superboot.core.result.ResultMessage;

/**
 * 学生模块 Servcie 类(单例).
 * 
 * @author 罗佳欣
 */
@Service
@Transactional
public class StudentService {

	/**
	 * 注入 Repository.
	 */
	@Autowired
	private StudentRepository studentRepository;

	/**
	 * 获取所有的学生.
	 * 
	 * @throws Exception
	 *             异常抛出.
	 * @return 结果集.
	 */
	public ResultMessage getStudentList() throws Exception {

		// 查询学生列表
		List<StudentPo> studentList = studentRepository.queryList(new StudentPo());

		// 组装结果数据
		Map<String, Object> resultParm = new HashMap<>();
		resultParm.put("studentList", studentList);

		// 生成结果集
		ResultMessage rs = ResultHelper.result(ResultEnum.GET_SUCCESS, resultParm);
		return rs;
	}

	/**
	 * 添加学生.
	 * 
	 * @param student
	 *            学生实例.
	 * @throws Exception
	 *             异常抛出.
	 * @return 结果集.
	 */
	public ResultMessage addStudent(final StudentPo student) throws Exception {
		// 参数校验
		if (student == null || student.getStudentname() == null || student.getAge() == null) {
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		// 组装学生实体
		StudentPo addPo = new StudentPo();
		addPo.setStudentname(student.getStudentname());
		addPo.setAge(student.getAge());

		// 添加学生
		studentRepository.addEntity(addPo, new UserPo());

		// 生成结果集
		ResultMessage rs = ResultHelper.result(ResultEnum.ADD_SUCCESS);
		return rs;
	}

	/**
	 * 删除学生.
	 * 
	 * @param student
	 *            学生实例.
	 * @throws Exception
	 *             异常抛出.
	 * @return 结果集.
	 */
	public ResultMessage removeStudent(final StudentPo student) throws Exception {
		// 参数校验
		if (student == null || student.getStudentid() == null) {
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}
		
		// 组装学生实体
		StudentPo delPo = new StudentPo();
		delPo.setStudentid(student.getStudentid());
		
		// 删除学生
		studentRepository.deleteEntity(delPo);

		// 生成结果集
		ResultMessage rs = ResultHelper.result(ResultEnum.DEL_SUCCESS);
		return rs;
	}

	/**
	 * 修改学生.
	 * 
	 * @param student
	 *            学生实例.
	 * @throws Exception
	 *             异常抛出.
	 * @return 结果集.
	 */
	public ResultMessage editStudent(final StudentPo student) throws Exception {
		// 参数校验
		if (student == null || student.getStudentid() == null) {
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		// 组装学生实体
		StudentPo editPo = new StudentPo();
		editPo.setStudentid(student.getStudentid());
		editPo.setStudentname(student.getStudentname());
		editPo.setAge(student.getAge());
		
		// 修改学生
		studentRepository.editEntity(editPo, new UserPo());

		// 生成结果集
		ResultMessage rs = ResultHelper.result(ResultEnum.EDIT_SUCCESS);
		return rs;
	}

	/**
	 * 根据 id 获取学生.
	 * 
	 * @param student
	 *            学生实例.
	 * @throws Exception
	 *             异常抛出.
	 * @return 结果集.
	 */
	public ResultMessage getStudent(final StudentPo student) throws Exception {
		// 参数校验
		if (student == null || student.getStudentid() == null) {
			throw new SuperException(ResultEnum.PARAM_ERROR);
		}

		// 根据 id 获取学生数据
		StudentPo queryPo = studentRepository.getEntityById(StudentPo.class, student.getStudentid());

		// 组装结果数据
		Map<String, Object> resultParm = new HashMap<>();
		resultParm.put("student", queryPo);
		
		// 生成结果集
		ResultMessage rs = ResultHelper.result(ResultEnum.GET_SUCCESS, resultParm);
		return rs;
	}

}