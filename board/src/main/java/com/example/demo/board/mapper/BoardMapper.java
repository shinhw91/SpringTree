package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.BoardVO;
import com.example.demo.board.BSearchVO;

@Mapper
public interface BoardMapper {
	List<BoardVO> getBoardList(BoardVO vo, BSearchVO svo);
	BoardVO getBoardInfo(String boardNo);
	int insertBoard(BoardVO boardVO);
	int deleteBoard(int boardNo);
}
