package com.example.test;

import java.util.Date;
import java.util.Objects;

//import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

//@Data
//@Builder
//@NoArgsConstructor
//@AllArgsConstructor
@RequiredArgsConstructor	// final 생성자 생성
@ToString
public class EmpVO {

	 private int employeeId;
	 final private String firstName;
	 final private String lastName;
	 private String email;
//	 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
	 private Date hireDate;
	 final private int salary;
	 private String jobId;
	 private String departmentId;
	 private String managerId;
	 private String phone;
	 
	 // 생성자
//	 public EmpVO() {}
//	 public EmpVO(String firstName, String lastName) {
//		 this.firstName = firstName;
//		 this.lastName = lastName;
//	 }
	 
	 public String getFirstName() {
		 return this.firstName;
	 }
	 
	 public String getLastName() {
		 return this.lastName;
	 }
	 
	 public int getSalary() {
		 return this.salary;
	 }

	@Override
	public boolean equals(Object obj) {
		EmpVO vo = (EmpVO) obj;	// 부모 자식간의 형변환 가능
		return this.firstName.equals(vo.getFirstName())
				&& this.lastName.equals(vo.getLastName());
	}

	@Override
	public int hashCode() {
		return Objects.hash(this.firstName, this.lastName);
	}
	
	
	 
	 
	 
}
