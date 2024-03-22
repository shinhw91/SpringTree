package com.yedam.app.emp.service.impl;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.emp.mapper.EmpMapper;
import com.yedam.app.emp.service.EmpService;

@Service
public class EmpServiecImpl implements EmpService{
	
	@Autowired EmpMapper empMapper;

	@Override
	public String getTime() {
		// TODO Auto-generated method stub
		return empMapper.getTime();
	}

	@Override
	public Map<String, Object> getInfo(String employeeId) {
		// TODO Auto-generated method stub
		return empMapper.getInfo(employeeId);
	}

}
