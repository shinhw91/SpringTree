package com.sam.app.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.sam.app.board.ReplyVO;

@Mapper
public interface ReplyMapper {
	List<ReplyVO> getReplyList();
	public int insertReply(ReplyVO vo);
}
