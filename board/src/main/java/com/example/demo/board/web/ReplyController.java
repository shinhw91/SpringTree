package com.example.demo.board.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.board.ReplyVO;
import com.example.demo.board.mapper.ReplyMapper;
import com.example.demo.emp.mapper.EmpMapper;

@RestController
public class ReplyController {
	@Autowired ReplyMapper mapper;
	
	// 페이지 이동
	@GetMapping("/replyMng")
	public ModelAndView replyMng() {
		ModelAndView mv = new ModelAndView("ReplyMng");
		return mv;
	}
	
	// 댓글전체 데이터
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
