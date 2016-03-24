package com.nishanth.springboot;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledClass {

	private static final SimpleDateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");

	@Scheduled(fixedRate = 20000)
	public void currentTime()
	{
		System.out.println("Current Time : "+dateFormat.format(new Date()));
	}
}
