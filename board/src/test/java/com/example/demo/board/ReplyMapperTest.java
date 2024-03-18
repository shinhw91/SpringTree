package com.example.demo.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.ReplyMapper;

@SpringBootTest
public class ReplyMapperTest {
	@Autowired ReplyMapper mapper;
	
	@Test
	public void 댓글등록() {
		ReplyVO vo = ReplyVO.builder()
					.rno(1)
					.bno(1)
					.reply("댓글등록1")
					.replyer("작성자1")
					.build();
		
		int result = mapper.insertReply(vo);
		
		System.out.println(result);
	}
	
	@Test
	public void 댓글전체조회() {
		List<ReplyVO> list = mapper.getReplyList();
		for(ReplyVO reply : list) {
			System.out.println(reply.rno + "," + reply.bno + "," + reply.reply);
		}
	}
	
	
}
