package spring.mvc.controller;

import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import spring.mvc.dao.MemberDao;
import spring.mvc.dto.MemberDto;
import spring.mvc.util.PagingUtil;

@Controller
public class SelectListController {

	@Autowired
	private MemberDao memberDao;

	@RequestMapping("/list.do")
	public ModelAndView process(@RequestParam(value = "pageNum", defaultValue = "1") int page) {

		List<MemberDto> list = null;

		int totalCount = memberDao.getMemberCount();

		/*
		 * page : 현재 페이지 totalCount : 전체 회원 수 rowCount : 한 페이지의 회원 수 pageCount :
		 * 한 화면에 보여줄 페이지 수 pageUrl : 호출 페이지 url
		 */

		PagingUtil pagingUtil = new PagingUtil(page, totalCount, 10, 10, "list.do");

		if (totalCount > 0) {
			list = memberDao.getMemberList(pagingUtil.getStartCount(), pagingUtil.getEndCount());
		} else {
			list = Collections.emptyList();
		}

		ModelAndView mav = new ModelAndView();
		mav.setViewName("selectList");
		mav.addObject("totalCount", totalCount);
		mav.addObject("list", list);
		mav.addObject("pagingHtml",pagingUtil.getPagingHtml());
		
		return mav;
	}

}
