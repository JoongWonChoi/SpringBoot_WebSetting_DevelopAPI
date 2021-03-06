package com.jwc.settingweb_boot.test;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.jwc.settingweb_boot.service.StatisticService;

@Controller
public class settingTest {
	
	@Autowired
	private StatisticService service;
	//연도별 접속자 수
	@ResponseBody //return 할 view 없이, 해당 메서드에서 return 해주는 값을 body로 삼아 바로 client에 노출
	@RequestMapping("/sqlyearStatistic")
	public Map<String, Object> sqlTest(String year) throws Exception{
		System.out.println("Request year = "+year);
		return service.yearloginNum(year);
	}
	
	//월별 접속자 수
	@ResponseBody
	@RequestMapping("/sqlmonthStatistic")
	public Map<String,Object> monthLogin(String year){ //요청된 year의 모든 월 별 접속자 수를 확인
		return service.monthloginNum(year);
	}
	
	//일자별 접속자 수
	@ResponseBody
	@RequestMapping("/sqldayStatistic")
	public Map<String,Object> dayLogin(String yearMonth){
		return service.dayloginNum(yearMonth);
	}
	
	
	
	//부서별 월별 로그인 수
	@ResponseBody
	@RequestMapping("sqlmonthByOrganizationStatistic")
	public Map<String, Object> monthByOrganization(String month, String organization){
		System.out.println("month : "+month+"org : "+organization); //'&'으로 연결된 여러개의 query string 인자가 모두 잘 전달 됨.
		return service.monthloginNumByOrganization(month, organization);
	
	}
	
	
	
	@RequestMapping("/test") 
	public ModelAndView test() throws Exception{
		System.out.println("test");
	
		
		ModelAndView mav = new ModelAndView("test");
		mav.addObject("name","jwc");
		List<String> resultList = new ArrayList<String>();
		resultList.add("!!!ControlletTest!!!");
		resultList.add("!!!Test1!!!");
		resultList.add("!!!Test2!!!");
		resultList.add("!!!Test3!!!");
		resultList.add("!!!Test4!!!");
		mav.addObject("list",resultList);
		return mav;
		
	}

}
