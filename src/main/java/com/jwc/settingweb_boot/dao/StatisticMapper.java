package com.jwc.settingweb_boot.dao;

import java.util.HashMap;

public interface StatisticMapper {
	//년도별 로그인 수
	public HashMap<String, Object> selectYearLogin(String year);
	//월별 로그인 수
	public HashMap<String, Object> selectMonthLogin(String year, String month);
	//일자별 접속 수
	public HashMap<String, Object> selectDayLogin(String yearMonth, String day);
	//평균 하루 로그인 수
	//휴일을 제외한 로그인 수
	//부서별 월별 로그인 수
	public HashMap<String, Object> selectMonthLoginByOrganization(String month, String organization);

}
