package com.comcast.crm.generic.webdriverutility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {
  public int GetRandomNum() {
	  Random random = new Random();
	  int randomNum = random.nextInt();
	  return randomNum;
  }
  public String getSystemDateYYYYMMDD() {
	  Date dateObj = new Date();
	  SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
	 String date = sdf.format(dateObj);
	 return date;
	  
  }
  public String getRequiredDateYYYYMMDD(int days) {
	  Date dateobj = new Date();
		SimpleDateFormat sim= new SimpleDateFormat("yyyy-MM-dd");
		String date = sim.format(dateobj);
		Calendar cal = sim.getCalendar();
		cal.add(Calendar.DAY_OF_MONTH, days);
		String reqDate= sim.format(cal.getTime());
		
	  
	  
	 /* SimpleDateFormat sim = new SimpleDateFormat("yyyy-MM-dd");
	  Calendar cal = sim.getCalendar();
	  cal.add(Calendar.DAY_OF_MONTH, days);
	  String reqDate= sim.format(cal.getTime());*/
	  return reqDate;
  }
}
