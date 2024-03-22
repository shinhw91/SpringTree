package com.sam.app.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.sam.app.board.ReplyVO;
import com.sam.app.board.mapper.ReplyMapper;

@RestController
public class ReplyController {
	@Autowired ReplyMapper mapper;
	

	@GetMapping("/replyMng")
	public ModelAndView replyMng() {
		ModelAndView mv = new ModelAndView("ReplyMng");
		return mv;
	}
	
	@GetMapping("/ajax/replyList")
	public List<ReplyVO> replyList() {
		return mapper.getReplyList();
	}
	
	@PostMapping("/ajax/reply")
	public ReplyVO save(ReplyVO vo) {
		mapper.insertReply(vo);
		return vo;
	}
	

}
