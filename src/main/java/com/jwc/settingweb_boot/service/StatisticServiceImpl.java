package com.jwc.settingweb_boot.service;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jwc.settingweb_boot.dao.StatisticMapper;

@Service
public class StatisticServiceImpl implements StatisticService{
	
	@Autowired
	private StatisticMapper uMapper;
	
	@Override
	public HashMap<String, Object> yearloginNum(String year){
		HashMap<String, Object> retVal = new HashMap<String, Object>();
		
		try {
			retVal = uMapper.selectYearLogin(year);
			retVal.put("year",year);
			retVal.put("is_success",true);
		}
		catch(Exception e) {
			retVal.put("totCnt", -999);
			retVal.put("year", year);
			retVal.put("is_success",false);	
		}
		return retVal;
	}
	@Override
	public HashMap<String, Object> monthloginNum(String year){
		HashMap<String, Object> result = new HashMap<String, Object>();
		
		String month[] = {"01","02","03","04","05","06","07","08","09","10","11","12"};
		ArrayList temp = new ArrayList();
		try {
			for(int i=0; i<12 ; i++) { //주어진 파라미터 년도의 달 별 접속자수를 위한 반복문
				//temp = uMapper.selectMonthLogin(year, month[i]);
				//result.put(month[i], uMapper.selectMonthLogin(year, month[i]));
				temp.add(uMapper.selectMonthLogin(year, month[i]));
				System.out.println(temp.get(i));
				//System.out.println(month[i]+" | "+temp.get(month[i]));
			}
			//result.put("month", month);
			result.put("year", year);
			result.put("cntByMonth", temp);
			result.put("is_success", true);
		}
		catch(Exception e) {
			result.put("totCnt", -999);
			result.put("month", month);
			result.put("is_success", false);
		}
		return result;
	}
	@Override
	public HashMap<String, Object> dayloginNum(String day){
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			result = uMapper.selectDayLogin(day);
			result.put("day", day);
			result.put("is_success", true);
		}
		catch(Exception e) {
			result.put("totCnt", -999);
			result.put("day", day);
			result.put("is_success", false);
		}
		return result;
	}
	
	
	@Override
	public HashMap<String, Object> monthloginNumByOrganization(String month, String organization){
		HashMap<String, Object> result = new HashMap<String, Object>();
		System.out.println("connect to service");
		try {
			System.out.println("1");
			result = uMapper.selectMonthLoginByOrganization(month, organization); //여기서 문제 발생!
			//아마 mapper에서 sql오류가 있지 않을까 예상
			System.out.println("2");
			result.put("month", month);
			System.out.println("3");
			result.put("organization", organization);
			System.out.println("4");
			result.put("is_success", true);
		}
		catch(Exception e) {
			System.out.println("fail");
			result.put("totCnt", -999);
			result.put("month", month);
			result.put("organization", organization);
			result.put("is_success", false);
		}
		return result;
	}


}
