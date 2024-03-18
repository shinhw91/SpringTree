package com.example.demo.board;

import java.sql.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ReplyVO {
	int rno;
	int bno;
	String reply;
	String replyer;
	Date replyDate;
	Date updateDate;
}
