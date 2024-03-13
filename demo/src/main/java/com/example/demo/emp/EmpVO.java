package com.example.demo.emp;

import java.util.Date;

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
	 Date hireDate;
	 Integer salary;
	 String jobId;
	 String departmentId;
	 String managerId;
	 String phone;
}
