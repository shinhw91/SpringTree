package com.sam.app.insa.service;

import lombok.Data;

@Data
public class DepartmentsVO {
	private int departments_id;
	private String departments_name;
	private int manager_id;
	private int location_id;
}
