package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dao.MemberDao;
import spring.mvc.dto.MemberDto;

@Controller
public class DetailController {
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value="/detail.do")
	public ModelAndView process(@RequestParam("id") String id){
//		System.out.println("process 호출");
		//ModelAndView mav = new ModelAndView();
		MemberDto member = memberDao.getDetailMember(id);
		
		return new ModelAndView("selectDetail", "member", member);
	}
}
