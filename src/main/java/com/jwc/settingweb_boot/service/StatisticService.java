package com.jwc.settingweb_boot.service;

import java.util.HashMap;

public interface StatisticService {
	public HashMap<String, Object> yearloginNum(String year);
	public HashMap<String, Object> monthloginNum(String month);
	public HashMap<String, Object> dayloginNum(String day);
	
	//부서별 월별 로그인 수
	public HashMap<String, Object> monthloginNumByOrganization(String month, String organization);

}
