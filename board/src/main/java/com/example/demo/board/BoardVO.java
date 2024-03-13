package com.example.demo.board;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardVO {
	int boardNo;
	String title;
	String content;
	String writer;
	String writeDate;
	String clickCnt;
	String image;
}
