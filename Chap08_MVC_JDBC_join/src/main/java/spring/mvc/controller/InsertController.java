package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import spring.mvc.dao.MemberDao;
import spring.mvc.dto.MemberDto;

@Controller
public class InsertController {
	
	@Autowired
	MemberDao memberDao;
	
	//view에 전달할 command 객체 생성, Spring에서 DTO를 커맨드라고 한다.
	@ModelAttribute
	public MemberDto formBacking(){
		return new MemberDto(); //memberDto 객체 생성
	}
	
	@RequestMapping(value = "insert.do", method = RequestMethod.GET)
	public String form() {
//		System.out.println("form 호출....");
		
		return "insertForm";
	}
	
	@RequestMapping(value="insert.do", method=RequestMethod.POST)
	public String submit(MemberDto memberDto){
//		System.out.println("submit() 호출...");
		memberDao.insertMember(memberDto);
		
		return "redirect:/list.do";
	}
}
