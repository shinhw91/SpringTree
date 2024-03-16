package com.example.test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Map;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JSON변환 {
	public static void main(String[] args) throws MalformedURLException, IOException {
		ObjectMapper objectMapper = new ObjectMapper();
		
		// object(객체) -> json(String)
		EmpVO vo = new EmpVO("길동", "홍");
//		vo.setFirstName("길동");
//		vo.setLastName("홍");
		
		String str = objectMapper.writeValueAsString(vo);
		System.out.println("JSON : " + str);
		
		// json -> object
		String json = "{\"employeeId\":0,\"firstName\":\"길동\",\"lastName\":\"홍\",\"email\":null,\"hireDate\":null,\"salary\":0,\"jobId\":null,\"departmentId\":null,\"managerId\":null,\"phone\":null}\r\n"
				+ "";
		vo = objectMapper.readValue(json, EmpVO.class);
		System.out.println("객체 : " + vo);
		
		// url -> object
		Map map = objectMapper.readValue(new URL("https://jsonplaceholder.typicode.com/todos/1"), Map.class);
		System.out.println(map.get("title"));
		
	}
}
