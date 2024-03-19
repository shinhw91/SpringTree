package com.example.demo.board.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.board.BSearchVO;
import com.example.demo.board.BoardVO;
import com.example.demo.board.mapper.BoardMapper;

@Controller
public class BoardController {
	@Autowired BoardMapper dao;
	
	@RequestMapping("/boardList")
	public String boardList(Model model, BoardVO vo, BSearchVO svo) {
		model.addAttribute("boardList", dao.getBoardList(vo, svo));
		return "boardList";
	}
}
