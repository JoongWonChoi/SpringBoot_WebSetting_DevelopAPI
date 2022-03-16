package com.jwc.settingweb_boot.service;

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
	public HashMap<String, Object> monthloginNum(String month){
		HashMap<String, Object> result = new HashMap<String, Object>();
		try {
			result = uMapper.selectMonthLogin(month);
			result.put("month", month);
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
		try {
			result = uMapper.selectMonthLoginByOrganization(month, organization);
			result.put("month", month);
			result.put("organization", organization);
			result.put("is_success", true);
		}
		catch(Exception e) {
			result.put("totCnt", -999);
			result.put("month", month);
			result.put("organization", organization);
			result.put("is_success", false);
		}
		return result;
	}


}
