package com.example.demo.emp.web;

import java.io.File;
import java.io.IOException;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.example.demo.emp.EmpVO;
import com.example.demo.emp.SearchVO;
import com.example.demo.emp.mapper.EmpMapper;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Controller	// 컨테이너 빈 등록 + 사용자요청 처리할 수 있는 커멘드 핸들러로 변환
public class EmpController {
	
	final EmpMapper mapper;	// 의존성주입(DI dependency Injection)
	
	@GetMapping("/emp/insert")
	public void insert() {
		
	}
	
	// 등록처리 -> employees 테이블에 photo 컬럼 추가
	@PostMapping("/insert")
		public String insert(@ModelAttribute("emp") EmpVO vo, MultipartFile[] photos) throws IllegalStateException, IOException {
		System.out.println(vo);
		if(photos != null) {
			for(MultipartFile photo : photos) {
				if(photo.getSize() > 0) {
					File file = new File("d:/upload", photo.getOriginalFilename());
					photo.transferTo(file);
					
					System.out.println(photo.getOriginalFilename());
					System.out.println(photo.getSize());
					
					vo.setPhoto(photo.getOriginalFilename());
				}
			}
		}
		mapper.insertEmp(vo);
		return "redirect:/emp/list";
	}
	
	// 수정페이지 이동
	@GetMapping("/emp/update")
	public void update() {
		
	}
	
	// 수정처리
	
	// 삭제처리
	
	// 상세조회 페이지이동
	@GetMapping("/emp/info/{employeeId}")
	public String info(Model model, @PathVariable int employeeId) {
		model.addAttribute("emp", mapper.getEmpInfo(employeeId));
		return "emp/info";
	}
	
	// 목록페이지로 이동
    @RequestMapping("/emp/list")
    public String empList(Model model, EmpVO vo, SearchVO svo){
       model.addAttribute("empList", mapper.getEmpList(vo, svo));
       return "emp/list";
    }
    
}
