package com.sam.app.board;

import lombok.Data;

@Data
public class BSearchVO {
	int start = 1;
	int end = 10;
	
	int[] boardNos;
}
