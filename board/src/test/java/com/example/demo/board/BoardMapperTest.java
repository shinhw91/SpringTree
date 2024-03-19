package com.example.demo.board;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.example.demo.board.mapper.BoardMapper;

@SpringBootTest
public class BoardMapperTest {

	@Autowired BoardMapper mapper;
	@Test
	public void 게시판전체조회() {
		BoardVO vo = new BoardVO();
		BSearchVO svo = new BSearchVO();
		
		svo.setBoardNos(new int[] {1,2,3});
		List<BoardVO> list = mapper.getBoardList(vo, svo);
		for(BoardVO board : list) {
			System.out.println(board.getBoardNo() + ":" + board.getTitle());
		}
	}
	
	@Test
	public void 게시판단건조회() {
		String boardNo = "1";
		BoardVO vo = mapper.getBoardInfo(boardNo);
		System.out.println(vo);
	}
	
	@Test
	public void 게시글등록() {
		BoardVO vo = BoardVO.builder()
					.boardNo(100)
					.title("제목")
					.content("본문")
					.writer("작성자")
//					.writeDate("2024-03-14")
//					.clickCnt(null)
//					.image(null)
					.build();
		
		int result = mapper.insertBoard(vo);
		
		System.out.println("등록된 게시글번호 : " + vo.getBoardNo());
		System.out.println("등록건수 = : " + result);
	}
	
	@Test
	public void 게시글삭제() {
		int boardNo = 41;
		int result = mapper.deleteBoard(boardNo);
		System.out.println(result);
	}
	
}
