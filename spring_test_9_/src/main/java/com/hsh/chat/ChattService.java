package com.hsh.chat;

import java.io.IOException;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

import javax.servlet.http.HttpSession;
import javax.websocket.EndpointConfig;
import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.springframework.stereotype.Component;

import com.hsh.member.MemberDTO;

@Component
@ServerEndpoint(value="/chatt/broadcasting", configurator=GetHttpSession.class)
public class ChattService {
	//httpsession 이아님 .. session에 접속한 사람의 정보를 저장함
	private static Set<Session> clients = Collections.synchronizedSet(new HashSet<Session>());
	
	//Client가 메세지를 전송 했을 경우 했을 때
	@OnMessage
	public void onMessage(String message, Session session){
		//동시 접속 시 .. 
		synchronized (clients) {
			for (Session cli : clients) {
				if(!cli.equals(session)){
					try {
						cli.getBasicRemote().sendText(message);//id+message
					} catch (IOException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}
	
	//Client 접속 시도 했을 때
	@OnOpen
	public void onOpen(Session session, EndpointConfig config){ 
		HttpSession httpSession= (HttpSession) config.getUserProperties().get("httpSession");//
		MemberDTO memberDTO = (MemberDTO) httpSession.getAttribute("member");
		clients.add(session);
	}
	
	//Client 접속 종료 했을 때 
	@OnClose
	public void onClose(Session session){
		clients.remove(session);
	}
		
		
}








