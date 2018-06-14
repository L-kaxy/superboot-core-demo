/**
 * Copyright (c) 2017-2018 Tianxin.  All rights reserved. 广州天新网络科技有限公司 版权所有.
 * 请勿修改或删除版权声明及文件头部.
 */
package com.tianxin.superboot.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tianxin.superboot.demo.controller.param.StudentParam;
import com.tianxin.superboot.demo.service.StudentService;
import com.wteam.superboot.core.result.ResultMessage;

/**
 * 学生模块 Controller.
 * 
 * @author 罗佳欣
 */
@RestController
@RequestMapping("student")
public class StudentController {

	/**
	 * 注入 service.
	 */
	@Autowired
	private StudentService service;

	/**
	 * 获取所有的学生.
	 * 
	 * @return 结果消息.
	 * @throws Exception
	 *             所有异常.
	 */
	@PostMapping("/getStudentList")
	public ResultMessage getStudentList() throws Exception {
		return service.getStudentList();
	}

	/**
	 * 添加学生接口.
	 * 
	 * @param param
	 *            请求参数.
	 * @return 结果消息.
	 * @throws Exception
	 *             所有异常.
	 */
	@PostMapping("/addStudent")
	public ResultMessage addStudent(@RequestBody StudentParam param) throws Exception {
		return service.addStudent(param.getStudent());
	}

	/**
	 * 删除学生.
	 * 
	 * @param param
	 *            请求参数.
	 * @return 结果消息.
	 * @throws Exception
	 *             所有异常.
	 */
	@PostMapping("/removeStudent")
	public ResultMessage removeStudent(@RequestBody StudentParam param) throws Exception {
		return service.removeStudent(param.getStudent());
	}

	/**
	 * 修改学生.
	 * 
	 * @param param
	 *            请求参数.
	 * @return 结果消息.
	 * @throws Exception
	 *             所有异常.
	 */
	@PostMapping("/editStudent")
	public ResultMessage editStudent(@RequestBody StudentParam param) throws Exception {
		return service.editStudent(param.getStudent());
	}

	/**
	 * 根据 id 获取学生.
	 * 
	 * @param param
	 *            请求参数.
	 * @return 结果消息.
	 * @throws Exception
	 *             所有异常.
	 */
	@PostMapping("/getStudent")
	public ResultMessage getStudent(@RequestBody StudentParam param) throws Exception {
		return service.getStudent(param.getStudent());
	}

}
