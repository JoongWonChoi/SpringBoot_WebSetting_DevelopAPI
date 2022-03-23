package com.jwc.settingweb_boot.service;

import java.util.HashMap;

public interface StatisticService {
	//년도별 로그인 수
	public HashMap<String, Object> yearloginNum(String year);
	//월별 로그인 수
	public HashMap<String, Object> monthloginNum(String year);
	//일자별 접속 수
	public HashMap<String, Object> dayloginNum(String yearMonth);
	//평균 하루 로그인 수
	
	//휴일을 제외한 로그인 수
	//부서별 월별 로그인 수
	public HashMap<String, Object> monthloginNumByOrganization(String month, String organization);

}
