package com.example.demo.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.example.demo.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList();
	public int insertReply(ReplyVO vo);
}
