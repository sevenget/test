package spring.mvc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dao.MemberDao;
import spring.mvc.dto.MemberDto;

@Controller
public class UpdateController {
	
	@Autowired
	MemberDao memberDao;
	
	@RequestMapping(value="/update.do", method=RequestMethod.GET)
	public ModelAndView form(@RequestParam("id") String id){ // 이 것이 전달된다는 것을 명시하기 위해서 @RequestParam을 지정?
		MemberDto memberDto = memberDao.getDetailMember(id);
		
		return new ModelAndView("updateForm", "memberDto", memberDto);
	}
	
	@RequestMapping(value="/update.do", method=RequestMethod.POST)
	public ModelAndView process(@RequestParam("id") String id){
		
		return null;
	}
	
}
