package com.example.demo.board;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {

	@Autowired BoardMapper mapper;
//	@Test
//	public void 게시판전체조회() {
//		BoardVO vo = new BoardVO();
//		SearchVO svo = new SearchVO();
//		
////		svo.setBoardNos(new int[] {);
//		List<BoardVO> list = mapper.getBoardList(vo, svo);
//	}
	
	@Test
	public void 게시판단건조회() {
		String boardNo = "1";
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
	}
	
}
