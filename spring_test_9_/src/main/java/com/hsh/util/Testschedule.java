package com.hsh.util;

import javax.inject.Inject;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.hsh.chat.ChattService;

@Component
public class Testschedule {
	
	@Inject
	private ChattService chattService;
	
	@Scheduled(fixedDelay=5000,initialDelay=1000)//fixedDelay=5000 5초간격
	public void fix1(){
		System.out.println("fixedDelay : 지정된 시간_5초 간격으로 호출");
		System.out.println("initialDelay=1000 : 최조 수행시에 1초 딜레이 가지고 실행");
		chattService.onMessage("delay_server가 보낸 메세지", null);
	}
	
	/*@Scheduled(fixedRate=5000)
	public void fix2(){
		System.out.println("fixedRate=5000 : 5초마다 반복");
		System.out.println("이전 수행의 종료를 기다리진 않는다.");
	}*/
	
	@Scheduled(cron="30 * * * * 3")//30초 , 매분 , 매시 , 매일 , 월 , 요일, 년도_생략가능 //*(모든거)
	public void fix3(){
		chattService.onMessage("cron_server가 보낸 메세지", null);
		System.out.println("매년, 매월, 매시, 매분, 30초마다 한번씩 실행");
	}
	
}




