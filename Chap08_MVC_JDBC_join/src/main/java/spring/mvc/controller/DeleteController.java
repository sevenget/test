package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import spring.mvc.dao.MemberDao;

@Controller
public class DeleteController {
	
	@Autowired
	private MemberDao memberDao;
	
	
	@RequestMapping("/delete.do")
	public String form(){
		return "deleteForm";
	}
	
	@RequestMapping("/deletePro.do")
	public String process(@RequestParam("id") String id){
		memberDao.deleteMember(id);
		return "redirect:/list.do";
	}
}
