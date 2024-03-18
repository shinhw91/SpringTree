package com.example.demo.emp;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EmpVO {

	 int employeeId;
	 String firstName;
	 String lastName;
	 String email;
	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")	// 입력 String -> Date
	 @JsonFormat(pattern = "yyyy-MM-dd HH:mm")	// 출력 Date -> String
	 Date hireDate;
	 Integer salary;
	 String jobId;
	 String departmentId;
	 String managerId;
	 String phone;
	 String photo;
}
